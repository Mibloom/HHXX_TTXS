package 生产者消费者;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 15:28
 **/
public class Consumer extends Thread{
    private WaitQueueBuffer buffer;

    public Consumer(WaitQueueBuffer buffer){
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
            buffer.consumer();
        }
    }
}
