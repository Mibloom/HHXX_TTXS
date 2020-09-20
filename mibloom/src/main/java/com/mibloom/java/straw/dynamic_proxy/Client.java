package com.mibloom.java.straw.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/18 16:30
 **/
public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ProdServer prodServer = new ProdServer();
        ProxyProdServerHandler proxyProdServerHandler = new ProxyProdServerHandler(prodServer);
        ClassLoader classLoader = prodServer.getClass().getClassLoader();
        Server proxy = (Server)Proxy.newProxyInstance(classLoader, new Class[]{Server.class}, proxyProdServerHandler);
        proxy.exec("黎鹏科");
        proxy.newExec("黎鹏科");

    }
}
