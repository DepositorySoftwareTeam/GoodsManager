package com.dst.goodsmanager.controller;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.mapper.TransitOutMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TransitOutController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private TransitOutMapper transitOutMapper;
    @RequestMapping(value = "/transit_out/add",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_out_add(){
        return "TransitOutAdd";
    }
    @RequestMapping(value = "/transit_out",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_out(Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        String itemsJson=JSON.toJSONString(transitOutMapper.listTransitOutOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "TransitOut";
    }
}
