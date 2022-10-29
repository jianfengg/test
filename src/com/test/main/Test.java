package com.test.main;

import java.util.Scanner;


import java.util.*;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String line = in.nextLine();
        if (null == line) {
            System.out.println("content is blank");
            return;
        }
        List<String> numberList = Arrays.asList(line.split(","));
        //递归
        int size = numberList.size();
        Map<String, Long> all = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Map<String, Long> thisResult = new HashMap<>();
            thisResult.put(String.valueOf(i), Long.parseLong(numberList.get(i)));
            Map<String, Long> stringLongMap = getSum2(thisResult, numberList, 0);
            all.putAll(stringLongMap);
        }
        Collection<Long> values = all.values();
        List<Long> longList = values.stream().sorted((o1, o2) -> (int) (o1 - o2)).collect(Collectors.toList());
        long value = longList.get(0);
        for (int i = 1; i < longList.size(); i++) {
            Long aLong = longList.get(i);
            if (aLong > value) {
                value = aLong;
            }
        }
        System.out.println(value);
    }

    public static Map<String, Long> getSum2(Map<String, Long> results, List<String> numberList, int s) {
        if (s == numberList.size() - 1) {
            return results;
        }
        Map<String, Long> thisResults = new HashMap<>();
        for (String key : results.keySet()) {
            long str = results.get(key);
            List<Integer> strings = Arrays.stream(key.split("_")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < numberList.size(); j++) {
                if (strings.contains(j)) {
                    continue;
                }
                String str2 = numberList.get(j);
                try {
                    thisResults.put(key + "_" + j, Long.parseLong(str + str2));
                } catch (Exception ignored) {

                }
            }
        }
        return getSum2(thisResults, numberList, s + 1);
    }
}