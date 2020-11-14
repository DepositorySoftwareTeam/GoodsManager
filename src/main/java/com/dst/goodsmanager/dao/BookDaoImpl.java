package com.dst.goodsmanager.dao;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String insertSQL="insert into account values(?,?)";
    public int[] addUser(List<Object[]> batchArgs){
        return jdbcTemplate.batchUpdate(insertSQL,batchArgs);
    }
}