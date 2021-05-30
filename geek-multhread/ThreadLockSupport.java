package org.lql.multithreading.work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lql
 * @date: 2021/5/30 20:58
 * @description:
 */
public class ThreadLockSupport {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        int sum = 0;
        MyThread myThread = new MyThread(sum, "T1");

        // 异步执行 下面方法
        myThread.start();
        Thread.sleep(1000L);
        LockSupport.unpark(myThread);
        myThread.join();

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
        private int sum;

        public MyThread(int sum, String name) {
            super(name);
            this.sum = sum;
        }

        @Override
        public void run() {
            LockSupport.park();
            sum = sum();
        }
    }

}
