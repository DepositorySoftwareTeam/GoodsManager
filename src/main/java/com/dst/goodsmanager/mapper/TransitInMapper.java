package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.TransitIn;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface TransitInMapper {
    // Item queryItemByBarcode(String barcode);
    List<TransitIn> listTransitInOfUserId(long id);
    int addTransitIn(TransitIn transitIn);
    // int updateItemByBarcode(Item item);
}
