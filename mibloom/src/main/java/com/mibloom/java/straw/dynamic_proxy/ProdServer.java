package com.mibloom.java.straw.dynamic_proxy;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/18 16:28
 **/
public class ProdServer implements Server {

    @Override
    public void exec(String command){
        System.out.println(command + "：执行成功");
    }

    @Override
    public void newExec(String command) {
        System.out.println("哈哈哈，我是新的方法");
    }
}
