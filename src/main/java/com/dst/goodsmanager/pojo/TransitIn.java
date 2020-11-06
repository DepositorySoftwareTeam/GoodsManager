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
public class TransitIn {
    private long transit_in_id;
    private long username_id;

    @JSONField
    private String supplier;
    @JSONField
    private String barcode;

    @JSONField
    private String price_in;
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
    public TransitIn(long username_id,String supplier, String barcode,String price_in, long amount,String location,Date date, String operator, String comments) {
        this.username_id = username_id;
        this.barcode = barcode;
        this.location=location;
        this.price_in = price_in;
        this.amount = amount;
        this.date = date;
        this.operator = operator;
        this.supplier = supplier;
        this.comments = comments;
    }
}
