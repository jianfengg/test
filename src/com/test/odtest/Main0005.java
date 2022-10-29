package com.test.odtest;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/7
 * Time: 14:01
 * Description:
 */
public class Main0005 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int len = scanner.nextInt();
            int[] jobCount = new int[len];
            for (int i = 0; i < len; i++) {
                jobCount[i] = scanner.nextInt();
            }
            solution(n, jobCount);
            solution1(n, jobCount);
        }
    }

    private static void solution(int n, int[] jobCount) {
        int time = 0;
        int remaining = 0;
        for (int count : jobCount) {
            if (count + remaining > n) {
                remaining = count + remaining - n;
            } else {
                remaining = 0;
            }
            time++;
        }
        time += remaining / n;
        if (remaining % n > 0) {
            time++;
        }
        System.out.println(time);
    }

    /**
     *
     * @param n 单次解决问题数量
     * @param jobCount 任务数组、每次添加进来的个数
     */
    private static void solution1(int n, int[] jobCount) {
        //总时间
        int time = 0;
        //上一个任务执行的剩余数量
        int remaining = 0;
        for (int job : jobCount) {
            if (job + remaining > n) {
                //当前任务数 + 上次任务数 > 单次执行的
                remaining = (job + remaining) - n;
            } else {
                remaining = 0;
            }
            time ++;
        }

        if (remaining > 0) {
            if (remaining > n) {
                time += (remaining / n) + 1;
            } else {
                time ++;
            }
        }
        System.out.println(time);
    }
}
