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
public class Supplier {
    private long username_id;
    @JSONField
    private String supplier_name;
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
    public Supplier(
        long username_id,
        String supplier_name,
        Date date,
        String operator,
        String mobilephone,
        String telephone,
        String address,
        String comments
        ){
        this.username_id=username_id;
        this.supplier_name=supplier_name;
        this.date=date;
        this.operator=operator;
        this.mobilephone=mobilephone;
        this.telephone=telephone;
        this.address=address;
        this.comments=comments;
    }
}

