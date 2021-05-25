package org.lql.netty.router;

import java.util.List;

/**
 * @author: lql
 * @date: 2021/5/25 21:17
 * @description: Http Endpoint Router
 */
public interface HttpEndpointRouter {

    /**
     * route
     *
     * @param endpoints 端口
     * @return 路由地址
     */
    String route(List<String> endpoints);

    // Load Balance
    // Random
    // RoundRibbon
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50
}
