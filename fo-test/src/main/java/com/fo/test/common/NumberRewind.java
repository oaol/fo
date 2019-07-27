package com.fo.test.common;

/**
 * 如果整数运算超出了指定整数类型的范围，不会上溢或下溢，而是直接回绕
 * 
 * @author bryce
 * @Date Jul 24, 2019
 */
public class NumberRewind {
    public static void main(String[] args) {
        byte b1 = 127, b2 = 3; // byte类型的最大值是127
        byte sum = (byte)(b1 + b2); // 加法运算的结果直接回绕到-128，即byte类型的最小值
        System.out.println(sum);
    }
}
