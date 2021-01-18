package com.test.objtest;

import java.util.Objects;

public class ObjectsTest {

    public static void main(String[] args) {
        String s = Objects.toString("a", "b");
        System.out.println(s);
        for (int i = 0; i < args.length; i++) {
            System.out.println(i == 0 ? args[i] : "X " + args[i]);

        }

        String ss = "";
        System.out.println(ss);

        Integer i1 = 2;
        Integer i2 = 2;
        System.err.println(i2.intValue() == i1);

        System.out.println(String.format("配件号：[%s] 为特定件，特定件代码不能为空！！","item.getCode()"));
    }
}
