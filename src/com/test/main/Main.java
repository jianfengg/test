package com.test.main;

import java.math.BigDecimal;

/**
 * @author gjf
 * @description
 * @date 2021/9/10  15:56
 */
public class Main {

    public static void main(String[] args) {
//        testStringFormat();
//        testDecimal();
//        testSplit();

        String format = String.format("【优加小巴】尊敬的乘客您好，因未提前到达上车点等候，您原定于在%s月%s日%s分从%s到%s的行程已被司机取消，如有疑问请联系客服。",
                5, 4, "12:00", 32, 32);

        System.out.println(format);
    }

    public static void testDecimal() {

        int realPay = 1;
        BigDecimal drawRate = BigDecimal.valueOf(10);
        BigDecimal divide = new BigDecimal(realPay).multiply(drawRate).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);

        int i = divide.intValue();
        System.out.println(i);
        BigDecimal decimal = BigDecimal.valueOf(0.5).setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(BigDecimal.valueOf(0.5).intValue());
        System.out.println(BigDecimal.valueOf(0.5).setScale(0, BigDecimal.ROUND_HALF_UP));
    }

    private static void testDoubleValue() {
        Double d = 9.99;
        System.out.println(d.longValue());
    }


    private static void testSplit() {
        String s = "sda*xsa";

        String[] split = s.split("\\*");
        for(String s1 : split) {
            System.out.println(
                    s1
            );
        }

        System.out.println(String.format("%03d", 3));

        System.out.println(Math.abs(-123));
    }
    
    private static void testStringFormat() {
        String msgContent = String.format("「%s」师傅，您有新的定制巴士排班安排。请登陆司机端核对排班信息，如有疑问请及时联系车队负责人。",
                "q3");
        System.out.println(msgContent);
    }

    private static int testOverLoad() {
        return 1;
    }

    private static long testOverLoad(Integer i) {

        return i;
    }


}
