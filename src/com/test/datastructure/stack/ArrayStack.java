package com.test.datastructure.stack;

/**
 * @Description: 定义栈
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/14 9:30
 * @UpdateDate: 2021/5/14 9:30
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class ArrayStack {

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
