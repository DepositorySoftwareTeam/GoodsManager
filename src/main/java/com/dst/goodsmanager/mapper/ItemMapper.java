package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.Item;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ItemMapper {
    Item queryItemByBarcode(String barcode);
    List<Item> listItemOfUser(String username);
    int addItemOfUser(Item itemOfUser);
    int updateItemByBarcode(Item item);
}
