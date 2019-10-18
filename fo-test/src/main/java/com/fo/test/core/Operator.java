package com.fo.test.core;

/**
 * 运算符
 * @author bryce
 * @Date Jul 28, 2019
 */
public class Operator {
    public static void main(String[] args) {
        int a = 2;
        a*=2;
        System.out.println(a);
        increment();
        Long c = 128L;
        Long d = 128L;
        System.out.println(c == d);
    }
    
    /**
     * 
     * @return
     */
    public static void increment() {
        int i = 1;
        // j = 2 i = 2, 返回2
        int j = ++i;
        // f = 2 i = 3,返回2
        int f = i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(f);
    }
}
