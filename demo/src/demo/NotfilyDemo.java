package demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lipengke
 * @description:
 * @date 2020/5/4 17:46
 */
public class NotfilyDemo {

    volatile int a;

    public static void main(String[] args) {
        NotfilyDemo demo = new NotfilyDemo();
        NotfilyDemo demo2 = new NotfilyDemo();
        new Thread(() -> {
            demo.fun(demo);
        }).start();
        new Thread(() -> {
            demo.fun(demo);
        }).start();
        new Thread(() -> {
            demo.fun(demo);
        }).start();
        new Thread(() -> {
            demo.fun(demo);
        }).start();
        new Thread(() -> {
            demo.fun(demo);
        }).start();
        new Thread(() -> {
            demo.fun(demo);
        }).start();
        new Thread(() -> {
            demo.fun1(demo);
        }).start();
    }

    public void fun1(NotfilyDemo demo){
        synchronized (this){
           notifyAll();
        }
    }
    public void fun(NotfilyDemo demo){
        ReentrantLock reentrantLock = new ReentrantLock();


        try {
            synchronized (demo){
                System.out.println(Thread.currentThread().getName());
                wait();
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
