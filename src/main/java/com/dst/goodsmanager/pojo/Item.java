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
public class Item {
    @JSONField
    private String username;
    @JSONField
    private String barcode;
    @JSONField
    private String profilephoto;
    @JSONField
    private String product_name;
    @JSONField
    private String price_in;
    @JSONField
    private String price_out;
    @JSONField
    private String amount;
    @JSONField(format="yyyy-MM-dd")
    private Date date;
    @JSONField
    private String operator;
    @JSONField
    private String customer;
    @JSONField
    private String comments;
    public Item(String username, String barcode, String profilephoto, String product_name, String price_in, String price_out, String amount, Date date, String operator, String customer, String comments) {
        this.username = username;
        this.barcode = barcode;
        this.profilephoto = profilephoto;
        this.product_name = product_name;
        this.price_in = price_in;
        this.price_out = price_out;
        this.amount = amount;
        this.date = date;
        this.operator = operator;
        this.customer = customer;
        this.comments = comments;
    }
}
