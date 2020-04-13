package demo;

import java.util.HashMap;

/**
 * @author lipengke
 * @description:
 * @date 2020/3/17 21:21
 */
public class Demo {
    public static void main(String[] args) {
        new HashMap<>();
        MyMap<Integer, String> map = new MyMap<>();
        map.put(1, "lpk");
        map.put(2, "lpk2");
        map.put(3, "lpk3");
        map.put(4, "lpk4");
        map.put(5, "lpk5");
        map.put(6, "lpk6");
        map.put(7, "lpk6");
        map.put(8, "lpk6");
        map.put(9, "lpk6");
        map.put(10, "lpk6");
        map.put(11, "lpk6");
        map.put(12, "lpk6");
        map.put(13, "lpk6");
        map.put(16, "lpk6");
        map.put(15, "lpk6");
        map.put(19, "lpk6");
        map.put(27, "lpk6");
        map.put(30, "lpk6");
        map.put(28, "lpk6");


        map.printMap();
        System.out.println(map.size());
        System.out.println(map.get(5));
    }
}
