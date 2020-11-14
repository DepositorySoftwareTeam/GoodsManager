package com.dst.goodsmanager.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.util.Map;



@SessionAttributes(value="user",types={String.class})
@Controller
@RequestMapping("/H")
public class HelloPage{
    @RequestMapping(
        value="/match/*/end"
        ,method=RequestMethod.GET
        ,params={"id!=3"}
        ,headers={"Accept-Language=en-US,en;q=0.9"}
        )
    @ResponseBody
    public String match(){
        System.out.println(new Throwable().getStackTrace()[0].toString());
        return "success";
    }
    @RequestMapping(
        value="/pathVar/{id}"
        ,method=RequestMethod.GET
        ,params={"id!=0"}
        ,headers={"Accept-Language=en-US,en;q=0.9"}
        )
    @ResponseBody
    public String PathVar(
        @PathVariable(value="id") Integer id
        ,@RequestParam(value="username") String username
        ,@RequestHeader(value="Accept-Language") String language
        ,@CookieValue("key") String cookie
        ,HttpServletResponse httpServletResponse
        ,HttpServletRequest httpServletRequest
        ,Map<String,Object> map
        ){
        System.out.println(id);
        System.out.println(username);
        System.out.println(language);
        System.out.println(cookie);

        //requestMap
        System.out.println(map.hashCode());
        System.out.println(map);

        int[] bound_10=new int[10];
        
        System.out.println(bound_10[id]);
        System.out.println(10/id);
        System.out.println(new Throwable().getStackTrace()[0].toString());
        return "success"; 
    }
    // @ExceptionHandler({ArithmeticException.class})
    // @ResponseBody
    // public String exceptionHandler(){
    //     String s=new Throwable().getStackTrace()[0].toString();
    //     System.out.println(s);
    //     return s;
    // }
}