package com.dst.goodsmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.mapper.TransitInMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TransitInController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private TransitInMapper transitInMapper;
    @RequestMapping(value = "/transit_in/add",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in_add(){
        return "TransitInAdd";
    }
    @RequestMapping(value = "/transit_in",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in(Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        String itemsJson=JSON.toJSONString(transitInMapper.listTransitInOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "TransitIn";
    }
}