package com.test.datastructure.stack;

import java.util.Scanner;

/**
 * @Description: 数据模拟栈
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/5/8 15:11
 * @UpdateDate: 2021/5/8 15:11
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        stack.push('a');

        System.out.println(stack.pop());
    }

    public static void test() {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        String key;
        //控制是否还进行循环
        boolean loop = true;
        while (loop) {
            System.out.println("e:退出");
            System.out.println("a:入栈");
            System.out.println("o:出栈");
            System.out.println("l:循环");
            key = scanner.next();
            switch (key) {
                case "a":
                    int nextInt = scanner.nextInt();
                    stack.push(nextInt);
                    break;
                case "o":
                    System.out.println(stack.pop());;
                    break;
                case "l":
                    stack.loopStack();
                    break;
                case "e":
                    loop = false;
                    break;
                default:
                    System.out.println("未知的命令");
                    break;
            }
        }
    }
}
