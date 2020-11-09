package com.dst.goodsmanager.mapper;

import com.dst.goodsmanager.pojo.SalerUser;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SalerUserMapper {
    SalerUser querySalerUserByUsername(String username);
    Long getIdSalerUserByUsername(String username);
    int addSalerUser(SalerUser salerUser);
    int addSalerUserProfile(SalerUser salerUser);

}
