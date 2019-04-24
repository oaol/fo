//package com.fo.common.core.util;
//
//import java.util.function.Supplier;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class TransactionHelper {
//    @Transactional
//    public <T> T withTransaction(Supplier<T> supplier) {
//        return supplier.get();
//    }
//    @Transactional
//    public void withTransaction(Runnable runnable) {
//        runnable.run();
//    }
//}