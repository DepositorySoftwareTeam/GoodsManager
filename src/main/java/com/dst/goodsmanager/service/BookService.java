package com.dst.goodsmanager.service;


import com.dst.goodsmanager.dao.BookDao;

import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;

import java.util.List;
@Component
@ConfigurationProperties(prefix = "bookserv")
@Order(-1)
@Transactional(
    propagation=Propagation.REQUIRED,
    isolation=Isolation.REPEATABLE_READ,
    timeout=-1,
    readOnly=false,
    rollbackFor=Exception.class
    // noRollbackFor=Exception.class
)
public class BookService {
    public String value; 
    @Autowired
    private BookDao bookDao;
    public int[] addUser(List<Object[]> batchArgs){
        return bookDao.addUser(batchArgs);
    } 
}