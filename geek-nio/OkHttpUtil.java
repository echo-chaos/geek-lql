package org.lql.nio.work;

import okhttp3.*;

import java.io.IOException;

/**
 * @author: lql
 * @date: 2021/5/17 23:12
 * @description: OkHttp
 */
public class OkHttpUtil {

    private static final OkHttpClient CLIENT = new OkHttpClient();

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) {
        String url = "http://localhost:8801/";
        okHttpGet(url);
        System.out.println("======================================");
        okHttpPost(url);
    }

    private static void okHttpGet(String url) {
        Request request = new Request.Builder().url(url).build();
        try (Response response = CLIENT.newCall(request).execute()) {
            String context = response.body().string();
            System.out.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void okHttpPost(String url) {
        Request request = new Request.Builder().url(url).build();
        try (Response response = CLIENT.newCall(request).execute()) {
            String context = response.body().string();
            System.out.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
