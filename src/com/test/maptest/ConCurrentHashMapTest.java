package com.test.maptest;

import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

        map.put("a", "b");

        System.out.println(map);
    }
}
