package com.mibloom.java.straw.controller;

import com.mibloom.java.straw.dynamic.DynamicLoadingPool;
import com.mibloom.java.straw.dynamic.Webhook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/8 23:31
 **/
@RestController
@RequestMapping("/mibloom")
public class WebhookController {
    @Resource
    DynamicLoadingPool<Webhook> dynamicLoadingPool;

    @RequestMapping("/wechat")
    public ResponseEntity<String> hello(
    ) {

        return ResponseEntity.ok("mibloom wechat");
    }


}
