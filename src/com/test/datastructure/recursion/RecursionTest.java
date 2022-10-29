package com.test.datastructure.recursion;

import java.math.BigDecimal;

/**
 * @Description: 递归测试
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/14 16:33
 * @UpdateDate: 2021/5/14 16:33
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class RecursionTest {

    public static void main(String[] args) {
        test(5);

        System.out.println(Math.max(1,6));
    }

    public static void test(int n) {
        if(n > BigDecimal.ROUND_CEILING) {
            test(n-1);
        }
        System.out.println(n);
    }
}
