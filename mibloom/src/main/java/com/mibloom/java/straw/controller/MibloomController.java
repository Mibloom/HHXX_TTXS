package com.mibloom.java.straw.controller;

import com.mibloom.java.straw.bean.Mibloom;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/8 23:31
 **/
@RestController
@RequestMapping("/mibloom")
public class MibloomController {

    @GetMapping("/hello")
    public ResponseEntity<Mibloom> hello(
            @RequestParam(value = "id", required = false) String id
    ) {
        String format = String.format("id 参数值为：%s", id);
        Mibloom mibloom = new Mibloom(format);
        return ResponseEntity.ok(mibloom);
    }

}
