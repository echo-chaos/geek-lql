package org.lql.netty.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.lql.netty.filter.HeaderHttpRequestFilter;
import org.lql.netty.filter.HttpRequestFilter;
import org.lql.netty.filter.ProxyBizFilter;
import org.lql.netty.outbound.httpclient.HttpOutboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: lql
 * @date: 2021/5/25 14:12
 * @description: Http Inbound Handler
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger 日志
     * proxyServer 代理服务器url
     * handler 业务处理
     * filter 请求头过滤
     * proxyBizFilter 请求头过滤
     */
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();
    private ProxyBizFilter proxyBizFilter = new ProxyBizFilter();

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            //http请求过滤
            proxyBizFilter.filter(fullRequest, ctx);
            //http请求处理
            handler.handle(fullRequest, ctx, filter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

}
