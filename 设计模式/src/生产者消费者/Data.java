package 生产者消费者;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/25 15:11
 **/
public class Data {
    private static AtomicInteger id = new AtomicInteger(0);
    private String name;

    public Data(){
        name = id.incrementAndGet() +"号数据";
    }

    public String getName(){
        return name;
    }
}
