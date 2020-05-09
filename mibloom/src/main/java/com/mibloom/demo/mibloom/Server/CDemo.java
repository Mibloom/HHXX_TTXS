package com.mibloom.demo.mibloom.Server;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/18 14:30
 */
@Component
@Setter
@Getter
@Slf4j
public class CDemo {
    @Autowired
    private ADemo aDemo;

    CDemo(){
        log.error("C 实例化");
    }
}
