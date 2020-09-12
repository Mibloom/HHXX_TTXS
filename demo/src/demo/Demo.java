package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lipengke
 * @description:
 * @date 2020/3/17 21:21
 */
public class Demo {

    public Demo() {
    }
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        new Thread(() -> {
            ParkDemo.test();
        }).start();
        new Thread(() -> {
            ParkDemo.test();
        }).start();

        reentrantLock.lockInterruptibly();

        CountDownLatch downLatch = new CountDownLatch(12);


    }

    static class ParkDemo{

        static void test() {
            try {
                reentrantLock.lock();
                System.out.println("lpklpklpk");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
