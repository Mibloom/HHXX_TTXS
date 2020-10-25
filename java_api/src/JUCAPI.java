import java.util.Collections;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LIPENGKE
 * @description: JUC 包
 * @date 2020/9/9 14:15
 **/
public class JUCAPI {

    public static void main(String[] args) {
        // 1.原子类变量 atomic 类
        AtomicInteger atomicInteger = new AtomicInteger(12);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicLong atomicLong = new AtomicLong(12);
        atomicInteger.get();
        atomicInteger.incrementAndGet();
        // 2. 和锁相关的类
        ReentrantLock reentrantLock = new ReentrantLock(false);
        reentrantLock.lock();
        reentrantLock.unlock();
        // 3.控制同步执行的一些类
        CountDownLatch countDownLatch = new CountDownLatch(12);
        countDownLatch.countDown();
        countDownLatch.getCount();
        // 4. 同步队列BlockingQueue的实现
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<>();
       // synchronousQueue.take();
        synchronousQueue.poll();
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(10);
        arrayBlockingQueue.add(null);
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();


        // 5.和线程池相关的类
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(12, 12, 60, TimeUnit.MINUTES,
                synchronousQueue);
        pool.execute(() -> {
            System.out.println("线程池");
        });

        new Thread(() -> {
            JUCAPI jucapi = new JUCAPI();
            try {
                jucapi.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            JUCAPI jucapi = new JUCAPI();
            try {
                jucapi.test3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        // monitor monitor exit monitor enter  On Deck


    }

    public synchronized void test(){
        synchronized (this){
            System.out.println("synchronized");
        }
    }
    public synchronized static void test2() throws InterruptedException {
            System.out.println("synchronized test2");
            Thread.sleep(60 * 1000);
    }
    public synchronized static void test3() throws InterruptedException {
        System.out.println("synchronized test3");
        Thread.sleep(6000);
    }
}
