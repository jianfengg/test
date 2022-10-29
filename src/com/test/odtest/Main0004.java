package com.test.odtest;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/2
 * Time: 16:41
 * Description:
 */
public class Main0004 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            solution(n);
            int fun = fun(n);
            System.out.println(fun);
        }
    }

    private static void solution(int n) {
        int step1 = 1, step2 = 1, step3 = 2;
        int step4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            step4 = step3 + step1;
            step1 = step2;
            step2 = step3;
            step3 = step4;
        }
        System.out.println(step4);
    }

    //使用递归实现，同理斐波那契数列（112358...）
    private static int fun(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int sum = 0;
        if (n > 3) {
            sum = fun(n - 1) + fun(n - 3);
        }
        return sum;
    }

}
