package org.lql.netty.outbound.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author: lql
 * @date: 2021/5/25 14:53
 * @description:
 */
public class FutureCallBack implements FutureCallback<HttpResponse> {

    @Override
    public void completed(HttpResponse httpResponse) {
        try {
            System.out.println("httpGet： " + EntityUtils.toString(httpResponse.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Exception e) {
        System.out.println("failed...");
    }

    @Override
    public void cancelled() {
        System.out.println("cancelled...");
    }
}
