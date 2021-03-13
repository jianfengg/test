package com.test.objtest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: 龚剑锋
 * @CreateDate: 2020/12/28 17:25
 * @UpdateDate: 2020/12/28 17:25
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu StringTest
 */
public class StringTest {

    public static void main(String[] args) {
        loodTest();
    }

    private static void loodTest() {

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long time2 = System.currentTimeMillis();
        System.out.println((time2-time1));
    }

    private static void testBi() {
        String s = String.format("asd:%s, sadasa:%s","2","3");
        System.out.println(s);
    }
}
