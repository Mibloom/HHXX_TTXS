package com.mibloom.demo.mibloom.Server;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/18 14:30
 */
@Component
@Slf4j
public class ADemo implements BeanNameAware, BeanPostProcessor, InitializingBean, DisposableBean {

    /**
     * 一.  对象创建
     * 1. 从xml配置的Bean,@Bean注解，或者Java代码BeanDefinitionBuilder中读取Bean的定义,实例化Bean对象；
     * 2. 设置Bean的属性；
     * 3. 注入Aware的依赖（BeanNameAware,BeanFactoryAware,ApplicationContextAware）;
     * 4.@PostConstruct 标注的方法；
     * 5. 执行通用的方法前置处理，方法： BeanPostProcessor.postProcessorBeforeInitialization()
     * 6. 执行 InitalizingBean.afterPropertiesSet() 方法
     * 7. 执行<bean>的 init-method </>
     * 8. 执行方法BeanPostProcessor.postProcessorAfterInitialization()
     * 9. 创建对象完毕；
     * 二.  对象销毁
     * 1. @PreDestory 标注的方法；
     * 2. 执行 DisposableBean.destory() 方法；
     * 2. 执行自定义的destory方法或者
     * 3. 销毁对象完毕
     */

    ADemo(){
        log.error("A 实例化");
    }
    @Autowired
    BDemo bDemo;

    @Override
    public void setBeanName(String s) {
        log.error(s);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.error("BeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.error("BeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.error("InitalizingBean.afterPropertiesSet()");
    }

    @PostConstruct
    public void init(){
        log.error("执行Bean自定义的初始化方法init,或者 @PostConstruct 标注的方法；");
    }

    @Override
    public void destroy() throws Exception {
        log.error("执行 DisposableBean.destory() 方法；");
    }

    @PreDestroy
    public void myDestory(){
        log.error("执行自定义的destory方法或者 @PreDestory 标注的方法；");
    }
}
