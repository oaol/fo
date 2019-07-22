package com.fo.test.cps;

import java.util.function.IntConsumer;
import java.util.function.Predicate;

/**
 * cps 尾递归
 * 
 * @author bryce
 * @Date Mar 26, 2019
 */
public class CpsTest {

    static int add(int x, int y) {
        return x + y;
    }

    static void cps(int x, int y, IntConsumer fun) {
        fun.accept(add(x, y));
    }

    public static void main(String[] args) {
        Predicate<Integer> test = x -> x > 1;
        boolean test2 = test.test(2);
        System.out.println(test2);
        // lamda or method refrence
//        cps(1, 2, x -> sys(x));
        cps(1, 2, CpsTest::sys);
    }

    public static void sys(int a) {
        System.out.println(a);
    }
}
