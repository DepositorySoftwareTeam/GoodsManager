package com.dst.goodsmanager.controller;

import com.dst.goodsmanager.pojo.Account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@Controller
@RestController
public class IndexController {
    @ApiOperation("about Account")
    @GetMapping(value = "getAccount")
    public Account getAccount(@ApiParam("about id") int id){
        return new Account();
    }
}