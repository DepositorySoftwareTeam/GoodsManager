package com.dst.goodsmanager.conf;

import java.util.HashMap;
import java.util.Map;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DruidConfig {
    // @Bean
    // public ServletRegistrationBean<StatViewServlet> view(){
    //     ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet());
    //     HashMap<String,String> initParameters=new HashMap<>();
    //     initParameters.put("loginUsername","root");
    //     initParameters.put("loginPassword","rootPassword");
    //     // initParameters.put("allow","localhost");
    //     bean.setInitParameters(initParameters);
    //     return bean;
    // }
    // @Bean
    // public FilterRegistrationBean<WebStatFilter> filter(){
    //     FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>();
    //     bean.setFilter(new WebStatFilter());
    //     Map<String,String> initParameters=new HashMap<>();
    //     initParameters.put("exclusions","*.js,*.css,/druid/*,/list");
    //     bean.setInitParameters(initParameters);
    //     return bean;
    // }
}