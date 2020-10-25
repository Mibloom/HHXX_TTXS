package 生产者消费者;

import java.util.concurrent.BlockingQueue;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 15:25
 **/
public class Produce extends Thread {
    private WaitQueueBuffer buffer;

    public Produce(WaitQueueBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep((long)(5000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.produce();
        }
    }
}
