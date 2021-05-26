package org.lql.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @author: lql
 * @date: 2021/5/25 17:09
 * @description: 过滤器
 */
public class ProxyBizFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        HttpHeaders headers = fullRequest.headers();
        String uri = fullRequest.uri();
        if (headers.get("lql") != null) {
            fullRequest.headers().set("lql", 666);
        } else {
            fullRequest.headers().add("lql", 888);
        }
        if (uri.startsWith("/test")) {

        } else {

        }
    }
}
