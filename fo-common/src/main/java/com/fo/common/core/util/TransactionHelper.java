//package ai.silot.ms.mmp.common.utils;
//
//import java.util.function.Supplier;
//
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Control lambda TRANSACTIONAL
// * 
// * @author bryce
// * @Date Apr 24, 2019
// */
//@Component
//public class TransactionHelper {
//
//    @Transactional
//    public <T> T withTransaction(Supplier<T> supplier) {
//        return supplier.get();
//    }
//
//    @Transactional
//    public void withTransaction(Runnable runnable) {
//        runnable.run();
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public <T> T withNewTransaction(Supplier<T> supplier) {
//        return supplier.get();
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void withNewTransaction(Runnable runnable) {
//        runnable.run();
//    }
//}