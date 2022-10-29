package com.test.odtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/7
 * Time: 14:40
 * Description:
 */
public class Main0006 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            List<Integer> highs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                highs.add(scanner.nextInt());
            }
            solution(h, highs);
        }
    }

    private static void solution(int h, List<Integer> highs) {
        highs.sort((h1, h2) -> {
            int diff1 = Math.abs(h1 - h);
            int diff2 = Math.abs(h2 - h);
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });

        for (int i = 0; i < highs.size(); i++) {
            System.out.print(highs.get(i));
            if (i != highs.size() - 1) {
                System.out.print(" ");
            }
        }
    }


}
