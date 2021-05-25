package org.lql.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author: lql
 * @date: 2021/5/25 16:20
 * @description: http请求过滤器
 */
public interface HttpRequestFilter {
    /**
     * http请求过滤器
     *
     * @param fullRequest 完整的http请求
     * @param ctx         channel处理上下文
     */
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
}
