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

public class TransitOut {
    private long transit_out_id;
    private long username_id;

    @JSONField
    private String buyer;
    @JSONField
    private String barcode;

    @JSONField
    private String price_out;
    @JSONField
    private long amount;

    @JSONField
    private String location;
    @JSONField(format="yyyy-MM-dd")
    private Date date;
    @JSONField
    private String operator;

    @JSONField
    private String comments;
    public TransitOut(long username_id,String buyer, String barcode,String price_out, long amount,String location,Date date, String operator, String comments) {
        this.username_id = username_id;
        this.barcode = barcode;
        this.location=location;
        this.price_out = price_out;
        this.amount = amount;
        this.date = date;
        this.operator = operator;
        this.buyer = buyer;
        this.comments = comments;
    }
}
