package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lipengke
 * @description:
 * @date 2020/3/17 21:21
 */
public class Demo {

    public Demo() {
    }

    public static void main(String[] args) {
        String s = "sd";
        ReentrantLock lock = new ReentrantLock();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 200, 60, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        HashMap<String, String> hashMap = new HashMap<>(1000);
        hashMap.put("lpk","123");
        System.out.println(hashMap.size());
        ArrayList<String> strings = new ArrayList<>();
    }



}
