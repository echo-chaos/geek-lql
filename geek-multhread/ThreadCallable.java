package org.lql.multithreading.work;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: lql
 * @date: 2021/5/30 20:42
 * @description:
 */
public class ThreadCallable {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        MyThread myThread = new MyThread();
        FutureTask<Integer> task = new FutureTask<>(myThread);
        // 异步执行 下面方法
        new Thread(task).start();

        //这是得到的返回值
        int result = 0;
        try {
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
        System.out.println("主线程结束：" + Thread.currentThread().getName());
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

    static class MyThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("看见我了没: " + Thread.currentThread().getName());
            return sum();
        }
    }
}
