package com.fo.test.cps;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * throw exception
 * 
 * @author bryce
 * @Date Mar 28, 2019
 */
@Slf4j
public class ExceptionCpsUtil {

    /**
     * @param a boolean
     * @param f exception instance
     */
    public static void trowException(Boolean a, RuntimeException e, Consumer<RuntimeException> f) {
        if (!a) {
            log.info(e.getMessage(), e);
            f.accept(e);
        }
    }

    public static void trowException(RuntimeException e) {
        throw e;
    }

    public static void main(String[] args) {
        trowException(false, new RuntimeException("xx"), ExceptionCpsUtil::trowException);
    }
}
