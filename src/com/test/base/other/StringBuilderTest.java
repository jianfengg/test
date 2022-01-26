package com.test.base.other;

/**
 * @author gjf
 * @description
 * @date 2021/11/23  14:27
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        builder.append("abdcdefg");
        System.out.println(builder.deleteCharAt(builder.length()-1).toString());
    }
}
