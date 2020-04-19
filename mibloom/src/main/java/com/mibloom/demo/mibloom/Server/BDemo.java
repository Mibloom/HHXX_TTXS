package com.mibloom.demo.mibloom.Server;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/18 14:30
 */
@Component
@Setter
@Getter
@Slf4j
public class BDemo  {
    BDemo(){
        log.error("B 实例化");
    }
}
