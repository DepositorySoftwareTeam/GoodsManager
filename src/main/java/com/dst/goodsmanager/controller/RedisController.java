package com.dst.goodsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    @GetMapping(value="test")
    public String getMethodName() {
        RedisConnection connection =  redisTemplate.getConnectionFactory().getConnection();
        connection.flushAll();
        redisTemplate.opsForValue().set("_key","_value");
        String res=redisTemplate.opsForValue().get("_key").toString();
        return res;
    }
}
