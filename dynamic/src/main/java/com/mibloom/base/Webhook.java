package com.mibloom.base;


import org.springframework.http.ResponseEntity;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/26 21:26
 **/
public interface Webhook {
    ResponseEntity<Object> receive(Object... args);
}
