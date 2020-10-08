package com.mibloom.java.straw.dynamic;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.instrument.ClassDefinition;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/26 21:49
 **/
@Service
public class DynamicLoadingPool<Webhook> {
    @Resource
    DefaultListableBeanFactory beanFactory;
    @Resource
    ApplicationContext applicationContext;

    public Webhook load(String loadingId, Class<Webhook> tClass,
                 String version, String className, URL[] urls) throws ClassNotFoundException {
        // 获取jar包配置
        DynamicJarBean jarConfig = new DynamicJarBean();
        jarConfig.setClassName(className);
        jarConfig.setJarUrl(urls);
        jarConfig.setVersion(version);
        // DynamicJarBean jarConfig = dynamicLaodingJarServie.readJarCofnig(loadingId);

        // 获取webhook 接口的类加载器
        ClassLoader webhookClassLoader = tClass.getClassLoader();

        // 从提供的url加载jar包进jvm
        URLClassLoader jarClassLoad = new URLClassLoader(jarConfig.getJarUrl(), webhookClassLoader);

        // 生成class对象
        Class<Webhook> aClass = (Class<Webhook>) Class.forName(jarConfig.getClassName(), true, jarClassLoad);

        // 自定义bean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(aClass);

        // 注入自定义bean
        beanFactory.registerBeanDefinition(jarConfig.getVersion(),beanDefinitionBuilder.getBeanDefinition());

        // 设置代理
        AnnotationAwareAspectJAutoProxyCreator proxyCreator = applicationContext.getBean(AnnotationAwareAspectJAutoProxyCreator.class);

        proxyCreator.setProxyClassLoader(jarClassLoad);

        // 卸载
        beanFactory.removeBeanDefinition(jarConfig.getVersion());
        //jarClassLoad.close();

        // 获取bean
        return tClass.cast(applicationContext.getBean(jarConfig.getVersion()));
    }


}
