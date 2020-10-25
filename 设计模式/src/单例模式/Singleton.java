package 单例模式;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author LIPENGKE
 * @description: 懒加载 线程安全 双重检查
 * static volatile synchronized
 * @date 2020/10/25 14:00
 **/
public class Singleton {
    private Singleton(){};
    // volatile 作用 禁止指令重排序，防止在第一个if (singleton == null)
    // 时singleton对象还是一个没有初始化完成的对象。
    private static volatile Singleton singleton;
    public static Singleton newInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
