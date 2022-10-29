package com.test.main;

import java.util.*;

public class Test2 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int b = in.nextInt();
        int c = in.nextInt();

        List<String> strings = Arrays.asList(a.split(" "));

        Stack<String>  x = new Stack<>();

        for (int i = b; i < c; i++) {
            x.push(strings.get(i));
        }

        for (int i = b; i<c ;i++) {
            strings.set(i, x.pop());
        }

        System.out.println(String.join(" ", strings));

    }

}
