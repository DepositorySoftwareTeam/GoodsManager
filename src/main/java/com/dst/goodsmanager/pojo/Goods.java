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
public class Goods {
    private long username_id;
    @JSONField
    private String barcode;
    @JSONField
    private String goodname;
    @JSONField
    private String good_photo="";

    public Goods(long username_id,String barcode,String goodname,String good_photo){
        this.username_id=username_id;
        this.barcode=barcode;
        this.goodname=goodname;
        this.good_photo=good_photo;
    }
}
