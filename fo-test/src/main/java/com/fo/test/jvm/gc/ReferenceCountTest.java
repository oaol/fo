package com.fo.test.jvm.gc;

/**
 * 引用计数 - 循环引用
 * 
 * @author bryce
 * @Date Jun 30, 2019
 */
public class ReferenceCountTest {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        
    }
}

class A {
}

class B {

}