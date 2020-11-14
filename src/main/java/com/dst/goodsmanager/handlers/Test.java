package com.dst.goodsmanager.handlers;


import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Test {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg", "<p>"+new Throwable().getStackTrace()[0].toString()+"</p>");
        model.addAttribute("array", Arrays.asList(
            "<p>"+new Throwable().getStackTrace()[0].toString()+"</p>",
            "<p>"+new Throwable().getStackTrace()[0].toString()+"</p>",
            "<p>"+new Throwable().getStackTrace()[0].toString()+"</p>")
        );
        return "test";
    }
}
