package com.test.exception;

/**
 * 测试final优先级
 */
public class FinalTest {

    public static void main(String[] args) {
        System.out.println(job());
    }

    public static int job() {
        try {
            job2();
//            job1();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            job3();
            return 3;
        }
    }

    public static void job1() {
        System.out.println("job1");
        throw new RuntimeException("手动异常");
    }

    public static void job2() {
        System.out.println("job2");
    }


    public static void job3() {
        System.out.println("job3");
    }
}
