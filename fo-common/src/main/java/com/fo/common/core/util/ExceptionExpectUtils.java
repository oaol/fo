package com.fo.common.core.util;

import java.util.function.Consumer;

/**
 * due exception with what you want
 * 
 * @author bryce
 * @Date Mar 28, 2019
 */
public class ExceptionExpectUtils {

    /**
     * @param a boolean
     * @param f exception instance
     */
    public static void expectTrue(Boolean a, RuntimeException e, Consumer<RuntimeException> f) {
        if (!a) {
            f.accept(e);
        }
    }

    /**
     * if a equals false throw exception e
     *   
     * @param a
     * @param e
     */
    public static void expectTrue(Boolean a, RuntimeException e) {
        expectTrue(a, e, ex -> {throw ex;});
    }

    public static void main(String[] args) {
        expectTrue(false, new RuntimeException("xxxxx"));
    }
}
