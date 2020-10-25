package 生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 15:12
 **/
public class BlockingQueueBuffer {
    private BlockingQueue<Data> queue;

    public BlockingQueueBuffer(int size){
        queue = new LinkedBlockingQueue<>(size);
    }

    public void produce(){
        try {
            Data data = new Data();
            queue.put(data);
           // System.out.println("生产" + data.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume(){
        try {
            Data data = queue.take();
         //   System.out.println("消费" + data.getName());
        }catch (Exception e){

        }

    }
}
