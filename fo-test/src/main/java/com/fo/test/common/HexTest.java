package com.fo.test.common;

import java.math.BigInteger;

/**
 * 16 进制转换
 * TODO
 * @author bryce
 * @Date Jun 30, 2019
 */
public class HexTest {

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(11));
        // 16
        String hex = "101";
        System.out.println(Long.parseLong(hex, 16));
    }
}
