package org.lql.netty.outbound.httpclient;

import com.sun.deploy.util.ArrayUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.lql.netty.filter.HeaderHttpResponseFilter;
import org.lql.netty.filter.HttpRequestFilter;
import org.lql.netty.filter.HttpResponseFilter;
import org.lql.netty.router.HttpEndpointRouter;
import org.lql.netty.router.RandomHttpEndpointRouter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author: lql
 * @date: 2021/5/25 14:13
 * @description: Http Outbound Handler
 */
public class HttpOutboundHandler {

    private CloseableHttpAsyncClient httpclient;
    private ExecutorService proxyService;
    private List<String> backendUrls;

    private HttpResponseFilter filter = new HeaderHttpResponseFilter();
    private HttpEndpointRouter router = new RandomHttpEndpointRouter();

    public HttpOutboundHandler(List<String> backends) {
        this.backendUrls = backends.stream().map(this::formatUrl).collect(Collectors.toList());
        int cores = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 1000;
        int queueSize = 2048;
        //拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        /*
         * corePoolSize 核心线程池大小
         * maximumPoolSize 最大线程池大小
         * keepAliveTime 线程最大空闲时间
         * unit 时间单位
         * workQueue 线程等待队列
         * threadFactory 线程创建工厂
         * handler 拒绝策略
         */
        proxyService = new ThreadPoolExecutor(cores, cores, keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(queueSize),
                new NamedThreadFactory("proxyService"),
                handler);
        //IO反应器配置
        IOReactorConfig ioConfig = IOReactorConfig.custom()
                .setConnectTimeout(1000)
                .setSoTimeout(1000)
                .setIoThreadCount(cores)
                .setRcvBufSize(32 * 1024)
                .build();
        //http异步客户端
        httpclient = HttpAsyncClients.custom().setMaxConnTotal(40)
                .setMaxConnPerRoute(8)
                .setDefaultIOReactorConfig(ioConfig)
                .setKeepAliveStrategy((response, context) -> 6000)
                .build();
        httpclient.start();
    }

    private String formatUrl(String backend) {
        return backend.endsWith("/") ? backend.substring(0, backend.length() - 1) : backend;
    }

    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, HttpRequestFilter filter) {
        String backendUrl = router.route(this.backendUrls);
        final String url = backendUrl + fullRequest.uri();
        filter.filter(fullRequest, ctx);
        proxyService.submit(() -> fetchGet(fullRequest, ctx, url));
    }

    private void fetchGet(final FullHttpRequest inbound, final ChannelHandlerContext ctx, final String url) {
        final HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        httpGet.setHeader("mao", inbound.headers().get("mao"));
        httpGet.setHeader("lql", "yeah");
        httpclient.execute(httpGet, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse httpResponse) {
                try {
                    handleResponse(inbound, ctx, httpResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            }

            @Override
            public void failed(Exception e) {
                httpGet.abort();
                e.printStackTrace();
            }

            @Override
            public void cancelled() {
                httpGet.abort();
            }
        });
    }

    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final HttpResponse endpointResponse) throws Exception {
        FullHttpResponse response = null;
        try {
            byte[] body = EntityUtils.toByteArray(endpointResponse.getEntity());
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", Integer.parseInt(endpointResponse.getFirstHeader("Content-Length").getValue()));
            //请求响应过滤
            filter.filter(response);
            for (Header e : endpointResponse.getAllHeaders()) {
                response.headers().set(e.getName(), e.getValue());
                System.out.println(e.getName() + " => " + e.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(response);
                }
            }
            ctx.flush();
            //ctx.close();
        }

    }

    private void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
