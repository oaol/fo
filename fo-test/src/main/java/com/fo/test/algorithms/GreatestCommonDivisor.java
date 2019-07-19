package com.fo.test.algorithms;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int gcd = gcd(6, 3);
        System.out.println(gcd);
    }

    /**
     * 两个非负整数的最大公约数
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

}
