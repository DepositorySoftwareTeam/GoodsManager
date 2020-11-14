package com.dst.goodsmanager.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
@Service
@ConfigurationProperties(prefix = "person")
@Validated
public class TestYaml {
    private String name;
    public void setName(String name){
        System.out.println(new Throwable().getStackTrace()[0].toString());
        this.name=name;
    }
    
    private String UUID;
    public void setUUID(String UUID){
        System.out.println(new Throwable().getStackTrace()[0].toString());
        this.UUID=UUID;
    }
    private String lastName;
    public void setLastName(String lastName){
        System.out.println(new Throwable().getStackTrace()[0].toString());
        this.lastName=lastName;
    }
    @Email
    private String email;
    public void setEmail(String email){
        System.out.println(new Throwable().getStackTrace()[0].toString());
        this.email=email;
    }
    public void show(){
        System.out.println(new Throwable().getStackTrace()[0].toString());
        System.out.println(name);
        System.out.println(UUID);
        System.out.println(lastName);
        System.out.println(email);
    }
}
