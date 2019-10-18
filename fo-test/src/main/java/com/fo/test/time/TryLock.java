package com.fo.test.time;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    public static void main(String[] args) {
        
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1L);
            if (lock.tryLock(100L, TimeUnit.MILLISECONDS)) {
                System.out.println("timeout");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
       
    }
}
