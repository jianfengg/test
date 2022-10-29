package com.test.odtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/12/15
 * Time: 23:26
 * Description:
 */
public class Main0002 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] arr1 = parseArray(scanner.nextLine());
            int[] arr2 = parseArray(scanner.nextLine());
            int k = scanner.nextInt();
            solution(arr1, arr2, k);
        }
    }

    private static void solution(int[] arr1, int[] arr2, int k) {
        int initialCapacity = arr1.length * arr1.length;
        List<Integer> sums = new ArrayList<>(initialCapacity);
        for (int x : arr1) {
            for (int y : arr2) {
                sums.add(x + y);
            }
        }
        sums.sort(Integer::compareTo);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += sums.get(i);
        }
        System.out.println(res);
    }

    private static int[] parseArray(String line) {
        String[] split = line.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}
