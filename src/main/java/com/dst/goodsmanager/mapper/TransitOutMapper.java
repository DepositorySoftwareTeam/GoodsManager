package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.TransitOut;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface TransitOutMapper {
    // Item queryItemByBarcode(String barcode);
    List<TransitOut> listTransitOutOfUserId(long id);
    int addTransitOut(TransitOut transitIn);
    // int updateItemByBarcode(Item item);
}
