package com.dst.goodsmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JumpController {
    @RequestMapping(value="/jump/login", method={RequestMethod.POST})
    public String jumpLogin () {
        return "redirect:/slogin?error";
    }

}
