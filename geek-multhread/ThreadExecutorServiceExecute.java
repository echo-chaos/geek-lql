package org.lql.multithreading.work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lql
 * @date: 2021/5/30 22:13
 * @description:
 */
public class ThreadExecutorServiceExecute {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        // 异步执行 下面方法
        AtomicInteger sum = new AtomicInteger();
        executorService.execute(() -> {
            sum.set(sum());
        });
        Thread.sleep(1000L);

        //这是得到的返回值
        int result = sum.get();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
        executorService.shutdown();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
