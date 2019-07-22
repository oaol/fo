package com.fo.common.core.util;

import java.util.function.Consumer;

/**
 * deal exception with what you want
 * 
 * Exception
 * @author bryce
 * @Date Mar 28, 2019
 */
public class ExceptionClassExpectUtils {

    /**
     * @param a boolean
     * @param f exception instance
     */
    public static void expectTrue(Boolean a, Exception e, Consumer<Exception> f) {
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
    public static void expectTrue(Boolean a, Exception e) {
        expectTrue(a, e, ExceptionClassExpectUtils::doThrow);
    }

    /**
     * throw Exceptoin instance in lambda use Generic type
     * 
     * @param e Exception instance
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <E extends Exception> void doThrow(Exception e) throws E{
        throw (E)e;
    }

}
