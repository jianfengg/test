package com.test.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gjf
 * @description 分数到小数
 * @date 2022/8/15  17:52
 */
public class FractionToDecimal {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal1(1, 6));

        StringBuilder sb = new StringBuilder("abcde");
        System.out.println(sb.substring(3));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        // 转 long 计算，防止溢出
        long a = numerator, b = denominator;
        // 如果本身能够整除，直接返回计算结果
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        // 如果其一为负数，先追加负号
        if (a * b < 0) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        // 计算小数点前的部分，并将余数赋值给 a
        sb.append(a / b).append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }


    public static String fractionToDecimal1(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        if (numerator * denominator < 0) {
            //小数，拼接负号
            builder.append("-");
        }

        //先求整数部分
        builder.append(numerator / denominator);
        //设置小数点
        builder.append(".");

        //小数部分处理

        int temp = numerator % denominator;
        Map<Integer, Integer> map = new HashMap<>();
        while (temp != 0) {
            //暂时当前位置
            map.put(temp, builder.length());
            temp *= 10;
            int t = temp / denominator;
            builder.append(t);
            temp = temp % denominator;
            if (map.containsKey(temp)) {
                int u = map.get(temp);
                return String.format("%s(%s)", builder.substring(0, u), builder.substring(u));
            }

        }
        return builder.toString();
    }
}
