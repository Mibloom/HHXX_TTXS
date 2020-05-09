package demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/20 19:36
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("hello world");
        super.run();
    }

    public static void main(String[] args) {

        Executors.newCachedThreadPool();//SynchronousQueue
        Executors.newFixedThreadPool(2); // LinkedBlockingQueue
        Executors.newSingleThreadExecutor(); //LinkedBlockingQueue

        Executors.newSingleThreadScheduledExecutor(); //DelayedWorkQueue
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);//DelayedWorkQueue

        Executors.newWorkStealingPool();
        new ThreadDemo().start(); //大写字母


        System.out.println("Ea".hashCode()); // 2112
        System.out.println("FB".hashCode()); // 2112
        int monthNumber;
        String month = null;

        switch (month) {
            case "Ea":
                monthNumber = 1;
                break;
            case "FB":
                monthNumber = 2;
                break;
            // case null:
            default:
                monthNumber = 0;
                break;
        }
        System.out.println(monthNumber);
    }


}
