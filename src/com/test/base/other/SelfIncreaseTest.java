package com.test.base.other;

/**
 * @Description: 测试自增
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/13 15:29
 * @UpdateDate: 2021/7/13 15:29
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class SelfIncreaseTest {

    public static void main(String[] args) {
        int i = 1;
        int j = i++;

        System.out.println(String.format("i=【%s】",i));
        System.out.println(String.format("j=【%s】",j));

        i = 1;
        int k = ++i;
        System.out.println(String.format("i=【%s】",i));
        System.out.println(String.format("k=【%s】",k));

    }
}
