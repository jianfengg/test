package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;


/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/15 15:05
 * @UpdateDate: 2021/7/15 15:05
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService service = newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service.execute(new Task());
        }
        System.out.println(Thread.currentThread().getName());
        service.shutdown();
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
}
