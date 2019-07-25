package com.fo.test.common;

/**
 * java core: number literal
 * 下划线增加可读性
 * @author bryce
 * @Date Jul 24, 2019
 */
public class WholeNumberLiteral {

    public static void main(String[] args) {
        // 整数字面量
        int a = 0xff; // 使用十六进制表示的十进制数255 
        int b = 0377; // 使用八进制表示的十进制数255 
        int c = 0b0010_1111; // 使用二进制表示的十进制数47 
        int d = 0XCAFEBABE; // 用来识别Java类文件的魔法数
        int e = 111_1;
        // 严格来说，负号是作用在字面量上的运算符，而不是字面量的一部分。
        int f = -2_2;
        System.out.println(d);
    }

}
