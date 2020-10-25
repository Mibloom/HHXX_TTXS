package 生产者消费者;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 15:58
 **/
public class WaitQueueBuffer {
    private Queue<Data> queue;
    private int size;

    public WaitQueueBuffer(int size){
        this.size = size;
        this.queue = new ArrayDeque<>(size);
    }

    public synchronized void produce(){
        if (queue.size() > size){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Data data = new Data();
            queue.offer(data);
            System.out.println("生产" + data.getName());

            notifyAll();
        }
    }

    public synchronized void consumer(){
        if (queue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Data data = queue.poll();
            System.out.println("消费" + data.getName());
            notifyAll();
        }
    }

}
