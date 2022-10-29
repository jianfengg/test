package com.test.odtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/11
 * Time: 12:08
 * Description:
 */
public class Main0008 {
    private static final List<List<Integer>> combines = new ArrayList<>();
    private static final List<Integer> combine = new ArrayList<>(3);
    private static int res = -1;

    /*
    双11众多商品进行打折销售，小明想购买一些自己心仪的商品，
    但由于受购买资金限制，所以他决定从众多心意商品中购买3件，
    而且想尽可能的花完资金，
    现在请你设计一个程序帮助小明计算尽可能花费的最大资金额
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String m = scanner.nextLine();
            int r = scanner.nextInt();
            solution(m, r);
        }
    }

    private static void solution(String m, int r) {

        String[] goodsPricesString = m.split(",");
        int[] goodsPrices = new int[goodsPricesString.length];
        for (int i = 0; i < goodsPricesString.length; i++) {
            goodsPrices[i] = Integer.parseInt(goodsPricesString[i]);
        }
        Arrays.sort(goodsPrices);
        if (goodsPrices.length < 3 ||
                goodsPrices[0] + goodsPrices[1] + goodsPrices[2] > r) {
            System.out.println(-1);
            return;
        }

        takeGoods(goodsPrices, 0);
        combines.stream()
                .map(list -> sum(list))
                .sorted(Integer::compareTo)
                .forEach(sum -> {
                    if (sum > res && sum <= r) {
                        res = sum;
                    }
                });

        System.out.println(res);

    }

    private static void takeGoods(int[] goodsPrices, int start) {
        if (combine.size() == 3) {
            combines.add(new ArrayList<>(combine));
            return;
        }
        for (int i = start; i < goodsPrices.length; i++) {
            combine.add(goodsPrices[i]);
            takeGoods(goodsPrices, i + 1);
            combine.remove(combine.size() - 1);
        }
    }

    private static Integer sum(List<Integer> prices) {
        int sum = 0;
        for (Integer i : prices) {
            sum += i;
        }
        return sum;
    }
}
