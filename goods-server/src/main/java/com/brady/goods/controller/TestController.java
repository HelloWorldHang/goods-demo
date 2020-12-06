package com.brady.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: *
 * @author: 司云航
 * @create: 2020-12-06 14:31
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "this is test";
    }

}
