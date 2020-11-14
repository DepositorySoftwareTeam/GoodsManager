package com.dst.goodsmanager.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ExceptionAdvice{
    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    @ResponseStatus(reason="__reason__",value = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public String exceptionHandler(){
        String s=new Throwable().getStackTrace()[0].toString();
        System.out.println(s);
        return s;
    }
}