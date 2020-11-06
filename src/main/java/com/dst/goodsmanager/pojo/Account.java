package com.dst.goodsmanager.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Account {
    @ApiModelProperty("your name")
    private String name="default name";
    @ApiModelProperty(value = "your money",example = "1")
    private Long money=1000L;
}
