package com.dst.goodsmanager.mapper;

import java.util.List;

import com.dst.goodsmanager.pojo.Account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
     List<Account> queryAccountList();
     String test1(String name);
}
