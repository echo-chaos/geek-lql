package org.lql.netty.router;

import java.util.List;
import java.util.Random;

/**
 * @author: lql
 * @date: 2021/5/25 23:42
 * @description: 权重路由分发
 */
public class WeightHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        int x = random.nextInt(10);
        //80%走server01 20%走server02
        if (x > size) {
            return urls.get(0);
        } else {
            return urls.get(1);
        }
    }
}
