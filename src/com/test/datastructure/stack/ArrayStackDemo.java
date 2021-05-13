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

/**
 * 定义栈
 */
class ArrayStack {

    /**
     * 存放数据
     */
    private int[] stack;

    /**
     * 定义栈的大小
     */
    private int stackSize;

    /**
     * 定义栈顶 初始化为-1，无数据
     */
    private int top = -1;

    public ArrayStack(int stackSize) {
        this.stackSize = stackSize;
        this.stack = new int[stackSize];
    }

    /**
     * 向栈中加入数据
     * @param data
     */
    public void push(int data) {
        //先判断栈满否，通过判断 栈定义的大小 == 栈顶+1 ？
        if(stackSize == top + 1) {
            System.out.println("栈满，不可添加");
            return;
        }
        top ++;
        stack[top] = data;
    }

    /**
     * 从栈中取数
     */
    public int pop() {
        //从栈中取数据，先进后出
        if(top == -1) {
            System.out.println("栈空，无数据");
            throw new RuntimeException("栈空，无数据");
        }
        int value = stack[top];
        top --;
//        System.out.println(value);
        return value;
    }

    /**
     * 遍历栈
     */
    public void loopStack() {
        if(top == -1) {
            System.out.println("栈空~~~");
        }
        int temp = top;
        for(int i = top; i > 0; i--) {
            System.out.println(stack[i]);

        }
    }

    /**
     * 判断栈是否为空
     * @return ture:空，false:不为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 获取顶部元素
     * @return 顶部元素
     */
    public int getTopData() {
        return stack[top];
    }
}