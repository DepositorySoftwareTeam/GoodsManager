package com.dst.goodsmanager.conf;

import java.util.Locale;

import com.dst.goodsmanager.interceptor.FirstInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration

public class WebMvc implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/url_product").setViewName("product");
        registry.addViewController("/csrf").setViewName("csrf");
        // registry.addViewController("/Login").setViewName("Login");
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new CustomViewResolver();
    }
    public static class CustomViewResolver implements ViewResolver{
        public View resolveViewName(String viewName,Locale locale) throws Exception{
            return null;
        }
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/H/*").excludePathPatterns("/url_product","/index","/test" );
    }
}
