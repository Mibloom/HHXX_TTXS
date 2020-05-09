package com.mibloom.demo.mibloom.Server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lipengke
 * @description:
 * @date 2020/5/5 13:46
 */
public class JDKProxyDemo implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ClassPathXmlApplicationContext hhh = new ClassPathXmlApplicationContext("hhh");

        return null;
    }
}
