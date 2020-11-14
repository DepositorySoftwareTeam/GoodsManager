package com.dst.goodsmanager.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public class FirstInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object handler) throws Exception{
        System.out.println(new Throwable().getStackTrace()[0].toString());
        httpServletRequest.setAttribute("xxx", "arg1");
        httpServletRequest.getRequestDispatcher("/test").forward(httpServletRequest, httpServletResponse);
        return false;
        // return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object handler,ModelAndView modelAndView) throws Exception{
        System.out.println(new Throwable().getStackTrace()[0].toString());
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object handler,Exception exception) throws Exception{
        System.out.println(new Throwable().getStackTrace()[0].toString());
    }
} 