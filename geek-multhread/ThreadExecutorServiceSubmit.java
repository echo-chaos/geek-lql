package org.lql.multithreading.work;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lql
 * @date: 2021/5/30 21:45
 * @description:
 */
public class ThreadExecutorServiceSubmit {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Integer sum = null;
        try {
            sum = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return sum();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 异步执行 下面方法
        executorService.shutdown();

        //这是得到的返回值
        int result = sum;

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

    static class MyThread {

    }
}
