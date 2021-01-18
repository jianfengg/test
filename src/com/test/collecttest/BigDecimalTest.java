package com.test.collecttest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalTest {

    /*public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");

        System.out.println(String.join(",",s));
    }*/
    public static void main(String[] args) {
//        testScale();

        BigDecimal b1 = new BigDecimal("0.00");
        System.out.println(b1.compareTo(BigDecimal.ZERO) == 0);
    }



    public static void testDivide(String[] args) {
        BigDecimal zero = new BigDecimal("0");
        BigDecimal zero1 = new BigDecimal("0.000001");
        System.out.println(zero1.compareTo(zero));
        System.out.println(zero1.setScale(2, BigDecimal.ROUND_UP));


        BigDecimal a = new BigDecimal("86");

        BigDecimal c = new BigDecimal("30");

        BigDecimal divide = a.divide(c, 0, BigDecimal.ROUND_UP);
        BigDecimal divide1 = a.divide(c, 0, BigDecimal.ROUND_DOWN);
        System.out.println(divide);
        System.out.println(divide1);
    }

    public static void testScale() {
       /* BigDecimal b1 = new BigDecimal("2.123123");
        BigDecimal b2 = new BigDecimal("2.125123");
        System.out.println(b1);
        System.out.println(b2);
        b1 = b1.setScale(2,BigDecimal.ROUND_HALF_UP);
        b2 = b2.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(b1);
        System.out.println(b2);*/
        for(int i =0; i < 4; i ++) {
            try {
                testException();
            } catch (Exception e) {
                System.out.println("报错了！");
            }
        }
    }

    public static void testException() throws Exception {
        throw new Exception("异常");
    }
}
