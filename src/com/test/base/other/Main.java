package com.test.base.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/16 17:11
 * @UpdateDate: 2021/7/16 17:11
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Main implements Cloneable{

    private Object obj = new Object();

    public static void main(String[] args) throws CloneNotSupportedException {
        Main main = new Main();

        Main clone = (Main) main.clone();

        main.obj = new Object();

        System.out.println(
                main.obj == clone.obj
        );
//        A a = new A("hello");
//        B b = new B("1");
//        a.setB(b);
//        System.out.println(a.toString());
//
//        changeA(a);
//        System.out.println(a.toString());
//
//        changeB2(b);
//        System.out.println(a.toString());
//
//        Object o = new Object();
//
//        Map<String, Object> map = new HashMap<>(12);
//        map.put("asd", 12);
//        map.get("asd");
//        System.out.println(map);

    }

    private static void changeA(A a) {
        a = new A("hi");
    }

    private static void changeB(B b) {
        b = new B("2");
    }

    private static void changeB2(B b) {
        b.setId("3");
    }

    public static class A implements Cloneable{
        public A(String name) {
            this.name = name;
        }

        private String name;

        private B b;

        public B getB() {
            return b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", b=" + b +
                    '}';
        }

        public void setB(B b) {
            this.b = b;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class B {
        public B(String id) {
            this.id = id;
        }

        private String id;

        @Override
        public String toString() {
            return "B{" +
                    "id='" + id + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
