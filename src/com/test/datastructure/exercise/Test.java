package com.test.datastructure.exercise;

/**
 * @author gjf
 * @description
 * @date 2022/2/22  19:42
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(1234567899));
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 回文数练习
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        /*if (x < 0) {
            return false;
        }
        StringBuilder str = new StringBuilder(String.valueOf(x));
        String[] split = str.toString().split("");
        if (split.length == 1) {
            return true;
        }
        str = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            str.append(split[i]);
        }

        long newNum = Long.parseLong(str.toString());


        return newNum == x;*/
        /*String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);*/

        if(x < 0) {
            return false;
        }
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }


    /**
     * 罗马数字练习
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int romanToInt(String s) {
        //MCMXCIV
        if (s.length() == 1) {
            return getValueByRoman(s.charAt(0));
        }
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            int value1 = getValueByRoman(s1); //1
            if ((i + 1) < s.length()) {
                char s2 = s.charAt(i +1);
                int value2 = getValueByRoman(s2);
                if (value2 > value1) {
                    value += (value2 - value1);
                    i++;
                } else {
                    value += value1;
                }
            } else {
                value += value1;
            }
        }
        return value;
    }

    public static int getValueByRoman(char roman) {
        int value = 0;
        switch (roman) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }



}
