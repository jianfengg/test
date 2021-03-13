package com.test.queue;

import java.util.Scanner;

/**
 * @Description: 数组模拟环形队列
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/3/13 16:08
 * @UpdateDate: 2021/3/13 16:08
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        //说明设置4, 其队列的有效数据最大是3

        CircleArrayQueue queue = new CircleArrayQueue(4);
        // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // 接收一个字符 判断是进行什么操作
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class CircleArrayQueue {

    /**
     * 队列最大数量
     * 实际最大容量会比此值小1 因为会有一个预留空间
     */
    private int maxSize;
    /**
     * 队列头序号 指向队列头部，分析出front是指向队列头的前一个位置.
     * 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
     */
    private int front;
    /**
     * 队列尾序号 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
     * 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
     */
    private int rear;
    /**
     * 队列中存在的值
     */
    private int[] arr;

    /**
     * 初始化队列
     *
     * @param maxSize
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        //由于int类型默认值就是0，因此此处可以不再进行赋值
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        //环形队列 下标不断循环的 取模
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        //直接判断两者是否相等就可以了
        return rear == front;
    }

    /**
     * 向队列中添加元素
     *
     * @param num
     */
    public void addQueue(int num) {
        if (isFull()) {
            System.out.println("队列已满，不可添加数据");
            return;
        }
        arr[rear] = num;
        //由于是环形队列，此处real不可进行自增, 判断下一个下标是多少
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中取出数据
     *
     * @return
     */
    public int getQueue() {
        //从队列中取出数据
        if (isEmpty()) {
            System.out.println("队列为空，无数据可取！");
            throw new RuntimeException("队列为空，无数据可取！");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 获得当前队列中的实际有效数据
     *
     * @return
     */
    public int queueSize() {
        /*因为是循环队列，所以可能出现最后一个数据的下标小于
        第一个数据下标的情况，因为需要统一加上maxSize，保证最终取模结果为正数
         */
        return (rear - front + maxSize) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据可取！");
            return;
        }
        //循环取数，不再直接循环数据中的元素，下标也不能从0开始了，应该直接从front开始
        for (int i = front; i < front + queueSize(); i++) {
            //环形队列，后进队列的数据下标可能小于先进队列中数据的下标
            System.out.printf("arr[%d]=[%d]\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 显示队列的头数据， 注意不是取出数据
     *
     * @return
     */
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
}
