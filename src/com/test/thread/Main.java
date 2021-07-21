package com.test.thread;

import java.util.concurrent.*;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/15 16:07
 * @UpdateDate: 2021/7/15 16:07
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ">>>>");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
            System.out.println("本条OK");
        }
        countDownLatch.await();
        System.out.println("xxxx");
        service.shutdown();
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ">>>>");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
