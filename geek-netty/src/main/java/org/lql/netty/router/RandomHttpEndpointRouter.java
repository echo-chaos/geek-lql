package org.lql.netty.router;

import java.util.List;
import java.util.Random;

/**
 * @author: lql
 * @date: 2021/5/25 21:18
 * @description: Random Http Endpoint Router
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
