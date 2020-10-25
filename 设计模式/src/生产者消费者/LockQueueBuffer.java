package 生产者消费者;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 16:43
 **/
public class LockQueueBuffer {
    private Queue<Data> queue;
    private int size;
    private Lock lock;
    private Condition produceCondition;
    private Condition consumerCondition;

    public LockQueueBuffer(int size){
        this.size = size;
        queue = new ArrayDeque<>(size);
        lock = new ReentrantLock();
        produceCondition = lock.newCondition();
        consumerCondition = lock.newCondition();
    }
    public void produce(){
        lock.lock();
        try {
            if (queue.size() >= size){
                try {
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                Data data = new Data();
                queue.offer(data);
                consumerCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }
    public void consumer(){
        lock.lock();
        try {
            if (queue.size() == 0){
                try {
                    consumerCondition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                Data data = queue.poll();
                produceCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }
}
