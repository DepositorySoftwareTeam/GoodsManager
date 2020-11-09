package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.Buyer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface BuyerMapper {
    List<Buyer> listBuyerOfUserId(long id);
    Buyer queryBuyerOfUserIdByBuyerName(
        @Param("username_id") long username_id,@Param("buyer_name") String buyer_name);
    int addBuyer(Buyer goods);
}
