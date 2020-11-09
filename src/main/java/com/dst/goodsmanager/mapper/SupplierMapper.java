package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.Supplier;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SupplierMapper {
    List<Supplier> listSupplierOfUserId(long id);
    Supplier querySupplierOfUserIdBySupplierName(
        @Param("username_id") long username_id,@Param("supplier_name") String supplier_name);
    int addSupplier(Supplier goods);
}
