package com.fo.test.core;

public class GenericTypeTest<T> {

    public GenericTypeTest(T t) {
    }

    public static <T> GenericTypeTest<T> getInstance(T t) {
        return new GenericTypeTest<>(t);
    }

    public static <T> T getInstance2(T t) {
        return t;
    }

    public static void main(String[] args) {
        GenericTypeTest<String> a = getInstance("1");
        System.out.println(a);
    }
}
