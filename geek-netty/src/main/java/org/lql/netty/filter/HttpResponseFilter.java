package org.lql.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author: lql
 * @date: 2021/5/23 23:32
 * @description: Http Response Filter
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}
