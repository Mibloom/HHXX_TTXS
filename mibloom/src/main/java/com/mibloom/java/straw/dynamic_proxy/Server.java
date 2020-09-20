package com.mibloom.java.straw.dynamic_proxy;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/18 16:27
 **/
public interface Server {

    /**
     * 执行
     * @param command 命令
     */
    void exec(String command);

    void newExec(String command);

}
