package com.brady.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: *
 * @author: 司云航
 * @create: 2020-12-06 14:31
 */
@RestController
public class TestController {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/test")
    public String test(){
        String num1 = redisTemplate.opsForValue().get("num1");
        return num1;
    }

}
