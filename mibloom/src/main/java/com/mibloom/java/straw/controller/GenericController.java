package com.mibloom.java.straw.controller;

import com.mibloom.java.straw.bean.Mibloom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/8 23:31
 **/
@RestController
@RequestMapping("/mibloom")
public class GenericController {

    @GetMapping("/{appName}")
    public ResponseEntity<String> hello(
         @PathVariable("appName") String appName
    ) {

        return ResponseEntity.ok(appName);
    }


}
