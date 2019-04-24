package com.fo.up.core;

import java.util.function.Supplier;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 函数式编程事务控制
 * 
 * @author bryce
 * @Date Apr 24, 2019
 */
@Component
public class TransactionHelper {

    @Transactional
    public <T> T withTransaction(Supplier<T> supplier) {
        return supplier.get();
    }
    @Transactional
    public void withTransaction(Runnable runnable) {
        runnable.run();
    }

    /**
     * 
     * @param supplier
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = Exception.class)
    public <T> T withoutTransaction(Supplier<T> supplier) {
        return supplier.get();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = Exception.class)
    public void withoutTransaction(Runnable runnable) {
        runnable.run();
    }
}