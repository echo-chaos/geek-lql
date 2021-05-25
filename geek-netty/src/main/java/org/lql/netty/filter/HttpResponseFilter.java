package org.lql.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author: lql
 * @date: 2021/5/25 16:21
 * @description: Http请求响应过滤器
 */
public interface HttpResponseFilter {
    /**
     * Http请求响应过滤器
     *
     * @param response res
     */
    void filter(FullHttpResponse response);
}
