package com.mibloom.java.straw.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/18 16:29
 **/
public class ProxyProdServerHandler implements InvocationHandler {

    private Object target;

    public ProxyProdServerHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object arg : args) {
            System.out.println(arg);
        }
        return method.invoke(target,args);
    }
}
