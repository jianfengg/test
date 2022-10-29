package com.test.thread;

public class MyThread1 {

    static Object o1 = new Object();
    static Object o2 = new Object();
    /*
    总结：避免锁的嵌套
     */
    // 模式死锁
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                System.out.println("o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(" o1 o2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println("o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("o2 o1 ");
                }
            }
        }).start();
    }
}
