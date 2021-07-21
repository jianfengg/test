package com.test.base.single;

/**
 * @Description: 双检锁/双重校验锁
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/13 15:49
 * @UpdateDate: 2021/7/13 15:49
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {}

    /**
     * JDK 版本：JDK1.5 起
     *
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：是
     *
     * 实现难度：较复杂
     *
     * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * getInstance() 的性能对应用程序很关键
     * @return
     */
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }
}
