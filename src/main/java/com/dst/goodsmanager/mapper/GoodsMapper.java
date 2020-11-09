package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.Goods;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface GoodsMapper {
    // Item queryItemByBarcode(String barcode);
    List<Goods> listGoodsOfUserId(long id);
    Goods queryGoodsOfUserIdByBarcode(@Param("username_id") long username_id,@Param("barcode") String barcode);
    
    int addGoods(Goods goods);
    int addGoodsWithPhoto(Goods goods);
    // int updateItemByBarcode(Item item);
}
