package org.lql.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author: lql
 * @date: 2021/5/25 16:20
 * @description: 请求响应头过滤器
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("Content-Type", "application/json");
        response.headers().setInt("Content-Length", response.content().readableBytes());
        response.headers().set("kk", "java-1-nio");
    }
}
