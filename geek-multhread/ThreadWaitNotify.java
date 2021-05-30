package org.lql.multithreading.work;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2021/5/30 20:32
 * @description:
 */
public class ThreadWaitNotify {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        Object object = new Object();
        int sum = 0;
        MyThread myThread = new MyThread(object, sum);

        // 异步执行 下面方法
        myThread.start();
        synchronized (object) {
            object.wait();
        }

        //这是得到的返回值
        int result = myThread.sum;

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

    static class MyThread extends Thread {
        private Object object;
        private int sum;

        MyThread(Object object, int sum) {
            this.object = object;
            this.sum = sum;
        }

        @Override
        public void run() {
            synchronized (object) {
                sum = sum();
                object.notify();
            }
        }
    }
}
