package com.fo.test.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListSortTest {
    public static void main(String[] args) {
        // age 
        List<Integer> asList2 = Arrays.asList(6,4,1);
        // 0 2 1

        // http request
        Map<String, Integer> a = new HashMap<>();
        a.put("age", 6);
        Map<String, Integer> b = new HashMap<>();
        b.put("age", 1);
        Map<String, Integer> c = new HashMap<>();
        c.put("age", 4);

        List<Map<String, Integer>> asList = Arrays.asList(a, b, c);

        System.out.println(asList);
//        asList.sort(new Comparator<Map<String,Integer>>() {
//            @Override
//            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
//                return asList2.indexOf(o2.get("age")) - asList2.indexOf(o1.get("age"));
//            }
//         });

        // Lambda version
        List<Map<String, Integer>> collect = asList.stream().sorted((x, y) -> {
            return x.get("age") - y.get("age");
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
