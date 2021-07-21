package com.test.base.single;

/**
 * @Description: 懒汉式-线程不安全
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/13 15:37
 * @UpdateDate: 2021/7/13 15:37
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Singleton1 {
    private static Singleton1 instance;

    /**
     * 私有化构造器
     */
    private Singleton1() {

    }

    /**
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：否
     *
     * 实现难度：易
     *
     * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
     * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
     */
    public static Singleton1 getInstance() {
        if(instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
