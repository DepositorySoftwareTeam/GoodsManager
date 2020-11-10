package com.dst.goodsmanager.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.mapper.StockMapper;
import com.dst.goodsmanager.pojo.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalerController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private StockMapper stockMapper;
    @RequestMapping(value = "/slogin",method = {RequestMethod.POST,RequestMethod.GET})
    public String slogin(){
        return "slogin";
    }
    @GetMapping("signup")
    public String signup(){
        return "signup";
    }
    // @RequestMapping(value = "/index",method = {RequestMethod.POST,RequestMethod.GET})
    // public String index(){
    //     return "index";
    // }

    @GetMapping("upload")
    public String upload(){
        return "upload";
    }
    @GetMapping("addprovider")
    public String addprovider(){
        return "addprovider";
    }
    @GetMapping("additem")
    public String additem(){
        return "additem";
    }
    @RequestMapping(value = "/",method = {RequestMethod.POST,RequestMethod.GET})
    public String empty(){
        return "redirect:/stock";
    }
    @RequestMapping(value = "/shop/{username}",method = {RequestMethod.POST,RequestMethod.GET})
    public String shop(@PathVariable String username,Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            username);
        if(id==null)
            return "ERROR";
        String itemsJson=JSON.toJSONString(stockMapper.listStockOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "stock";
    }
    @RequestMapping(value = "/stock",method = {RequestMethod.POST,RequestMethod.GET})
    public String stock(Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        String itemsJson=JSON.toJSONString(stockMapper.listStockOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "stock";
    }
    @RequestMapping(value = "/graph",method = {RequestMethod.POST,RequestMethod.GET})
    public String graph(){
        return "graph";
    }
}
