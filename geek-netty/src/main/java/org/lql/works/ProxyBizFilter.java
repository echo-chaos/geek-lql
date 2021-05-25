package org.lql.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.List;
import java.util.Map;

/**
 * @author: lql
 * @date: 2021/5/25 17:09
 * @description: 过滤器
 */
public class ProxyBizFilter implements HttpRequestFilter {

    public static ProxyBizFilter newInstance() {
        return new ProxyBizFilter();
    }

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        System.out.println("请求方法：" + fullRequest.method().name());
        System.out.println("请求url：" + fullRequest.uri());
        System.out.println("协议：" + fullRequest.protocolVersion().text());
        System.out.println("请求头：-----------------------------");
        HttpHeaders headers = fullRequest.headers();
        List<Map.Entry<String, String>> entries = headers.entries();
        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getKey() + " ===> " + entry.getValue());
        }
        String uri = fullRequest.uri();
        if (uri.startsWith("/lql")) {
            fullRequest.headers().set("lql", 666);
        } else {
            fullRequest.headers().add("lql", 888);
        }
        HttpHeaders httpHeaders = fullRequest.headers();
        if (httpHeaders == null) {
            httpHeaders = new DefaultHttpHeaders();
        }
        httpHeaders.add("proxy-tag", this.getClass().getSimpleName());
        List<Map.Entry<String, String>> entryList = httpHeaders.entries();
        if (entryList.size() > entries.size()) {
            int sub = entryList.size() - entries.size();
            System.out.println("自定义请求头：");
            for (int i = 0; i < sub; i++) {
                System.out.println(entryList.get(entries.size() + i).getKey() + " --> " + entryList.get(entries.size() + i).getValue());
            }
        }
    }
}
