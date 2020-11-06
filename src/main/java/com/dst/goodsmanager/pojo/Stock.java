package com.dst.goodsmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
@Validated
public class Stock{
    @JSONField
    private String barcode;
    @JSONField
    private String goodname;
    @JSONField
    private String good_photo="";
    @JSONField
    private String location;
    @JSONField
    private long  amount_in;
    @JSONField
    private String total_money_in;
    @JSONField
    private String amount_out="0";
    @JSONField
    private String total_money_out="0.00";
}
