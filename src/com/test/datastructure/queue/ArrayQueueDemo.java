package com.test.datastructure.queue;

import java.util.Scanner;

/**
 * @Description: 数组模拟队列
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/3/13 14:24
 * @UpdateDate: 2021/3/13 14:24
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class ArrayQueueDemo {

    /**
     * 要明白一个概念，队列中数据，随着前一个数据被取出，下一个数据应该在队列中向前移动一位
     * 所以，在取出数据之后，需要不断改变第一个数据的下标
     * 同理，往队列中新增数据进去，最后一个数据的下标向前移动一个就更好理解了
     */
    public static void main(String[] args) {
        //初始化大小为3的数组
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        //是否继续循环
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
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
                    //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头的数据
                    try {
                        int res = queue.showHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    //退出
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


/**
 * 队列对象
 */
class ArrayQueue {

    /**
     * 队列最大数量
     */
    private int maxSize;
    /**
     * 队列头序号 指向队列头部，分析出front是指向队列头的前一个位置.
     */
    private int front;
    /**
     * 队列尾序号 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
     */
    private int rear;
    /**
     * 队列中存在的值
     */
    private int[] arr;

    /**
     * 初始化队列
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 判断队列是否已经满了
     * @return
     */
    public boolean isFull() {
        //如果头部和最大值-1相等，则说明满了
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 向队列中添加数据
     * @param num
     */
    public void addQueue(int num) {
        if(isFull()) {
            System.out.println("队列已满，不可添加数据");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    public int getQueue() {
        //从队列中取出数据
        if(isEmpty()) {
            System.out.println("队列为空，无数据可取！");
            throw new RuntimeException("队列为空，无数据可取！");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空，无数据可取！");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=[%d]\n",i,arr[i]);
        }
    }

    public int showHead() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据可取！");
            throw new RuntimeException("队列为空，无数据可取！");
        }
        return arr[front+1];
    }
}
