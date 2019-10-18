package com.fo.test.core;

import java.util.Arrays;

/**
 * 
 * 在 for 循环中可以使用空语句表明循环体为空
 * @author bryce
 * @Date Jul 31, 2019
 */
public class NullStatement {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4};
        for(int i = 0; i < 4; a[i++]++) // 递增数组元素
            /* empty */; // 循环体是空语句
        System.out.println(Arrays.toString(a));
    }
}
