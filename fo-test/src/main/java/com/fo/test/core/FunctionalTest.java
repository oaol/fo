package com.fo.test.core;

import java.util.Arrays;
import java.util.List;

public class FunctionalTest {
    
    public static void main(String[] args) {
        forEachTest();
    }
    
    public static void forEachTest() {
        List<Integer> asList = Arrays.asList(1,2,3,8,9);
        for (Integer integer : asList) {
            System.out.print(integer);
        }
        System.out.println("--------");
        asList.forEach(integer -> {
            System.out.println(integer);
        });
    }

}
