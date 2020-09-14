package demo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/13 20:49
 */
public class Test {

    static ThreadLocal<Integer> local = new ThreadLocal<>();
    static ThreadLocal<Integer> local2 = new ThreadLocal<>();

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 123);
        hashMap.put(null, 123);
        hashMap.put(4, 123);
        hashMap.size();
        Test test = new Test();
        new Thread(() -> {
            try {
                test.fun(test);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread thread = new Thread(() -> {
            try {
                test.fun(test);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread currentThread = Thread.currentThread();
        ClassLoader loader = currentThread.getContextClassLoader();

        ArrayList<Integer> list = new ArrayList<>();
        list.remove(1);
        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
        copy.add(1);
        copy.get(0);
        copy.remove(0);

        List<Object> list1 = Collections.synchronizedList(new ArrayList<>());
        list1.get(1);

    }


    public void fun(Test test) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        objects.remove(1);
        synchronized (test){
            System.out.println(Thread.currentThread().getName());
            wait();
            System.out.println(Thread.currentThread().getName());
            ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put("","");

        }

    }

    class MyClassLoader extends ClassLoader{

    }

}
