package com.dst.goodsmanager.conf;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(profiles);
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("dst.group");
        Docket docketController = docket.enable(flag).select().apis(RequestHandlerSelectors.basePackage("com.dst.goodsmanager.controller")).paths(PathSelectors.ant("/**")).build();
        //Docket docketPojo = docket.enable(flag).select().apis(RequestHandlerSelectors.basePackage("com.dst.goodsmanager.pojo")).paths(PathSelectors.ant("/**")).build();
        RequestHandlerSelectors.withClassAnnotation(Configuration.class);
        RequestHandlerSelectors.withMethodAnnotation(GetMapping.class);
        return docket;
    }
    private  ApiInfo apiInfo(){
        Contact contact = new Contact("dst","graceon","graceon@github.com");
        return new ApiInfo(
            "dst小队",
            "仓储系统开发",
            "v1.0",
            "/",
            contact,
            "Apache 2.0",
            "graceon@github.com",
            new ArrayList<>()
        );
    }
}
