import 单例模式.Singleton;
import 生产者消费者.BlockingQueueBuffer;
import 生产者消费者.Consumer;
import 生产者消费者.Produce;
import 生产者消费者.WaitQueueBuffer;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 14:28
 **/
public class DesignPatternTest {
    public static void main(String[] args) {
        WaitQueueBuffer buffer = new WaitQueueBuffer(10);
        for (int i = 0; i < 5; i++) {
            new Produce(buffer).start();
            new Consumer(buffer).start();
        }
    }
}
