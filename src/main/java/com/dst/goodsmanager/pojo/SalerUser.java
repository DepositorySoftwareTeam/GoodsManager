package com.dst.goodsmanager.pojo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@ApiModel
public class SalerUser {
    public static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    private boolean enabled;
    private String password;
    private String username;
    private long username_id;
    private String nickname;
    private String user_photo;
    public SalerUser(){
        enabled=true;
    }
}
