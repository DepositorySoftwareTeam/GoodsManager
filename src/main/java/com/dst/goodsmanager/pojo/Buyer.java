package com.dst.goodsmanager.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
@Validated
public class Buyer {
    private long username_id;
    @JSONField
    private String buyer_name;
    @JSONField(format="yyyy-MM-dd")
    private Date date;
    @JSONField
    private String operator;
    @JSONField
    private String mobilephone;
    @JSONField
    private String telephone;
    @JSONField
    private String address;
    @JSONField
    private String comments;
    public Buyer(
        long username_id,
        String buyer_name,
        Date date,
        String operator,
        String mobilephone,
        String telephone,
        String address,
        String comments
        ){
        this.username_id=username_id;
        this.buyer_name=buyer_name;
        this.date=date;
        this.operator=operator;
        this.mobilephone=mobilephone;
        this.telephone=telephone;
        this.address=address;
        this.comments=comments;
    }
}

