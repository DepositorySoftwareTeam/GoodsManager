package com.dst.goodsmanager.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.mapper.BuyerMapper;
import com.dst.goodsmanager.pojo.Buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Parameter;

@Controller
public class BuyerController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private BuyerMapper buyerMapper;
    @RequestMapping(value = "/buyer",method = {RequestMethod.POST,RequestMethod.GET})
    public String buyer(Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        String itemsJson=JSON.toJSONString(buyerMapper.listBuyerOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "Buyer";
    }
    @RequestMapping(value = "/buyer/{buyer_name}",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in(@PathVariable String buyer_name,Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        Buyer buyer=buyerMapper.queryBuyerOfUserIdByBuyerName(id, buyer_name);
        if(buyer==null){
            buyer=new Buyer();
        }
        buyer.setBuyer_name(buyer_name);
        String itemsJson=JSON.toJSONString(buyer);
        model.addAttribute("data",itemsJson);
        return "BuyerDetail";
    }
    @RequestMapping(value = "/api/buyer/modify",method = {RequestMethod.POST,RequestMethod.GET})
    public String modify(
        @Parameter String buyer_name,
        @Parameter String date,
        @Parameter String operator,
        @Parameter String mobilephone,
        @Parameter String telephone,
        @Parameter String address,
        @Parameter String comments
        )
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat;
        try{
            dateFormat= formatter.parse(date);
        }catch(ParseException e){
            return "redirect:/buyer/"+buyer_name+"?error";
        }
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication(). getName());
        if(id==null)
            id=0L;
        Buyer buyer=new Buyer(
            id,
            buyer_name,
            dateFormat,
            operator,
            mobilephone,
            telephone,
            address,
            comments
            );
        buyerMapper.addBuyer(buyer);
        
        return "redirect:/buyer?add=1";
    }
}
