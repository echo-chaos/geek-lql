package org.lql.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.List;
import java.util.Map;

/**
 * @author: lql
 * @date: 2021/5/25 16:19
 * @description: 请求头过滤器
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println(" filter接收到的请求,url: " + uri);
        fullRequest.headers().set("mao", "soul");
    }
}
