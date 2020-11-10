package com.dst.goodsmanager.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.mapper.SupplierMapper;
import com.dst.goodsmanager.pojo.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Parameter;

@Controller
public class SupplierController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private SupplierMapper supplierMapper;
    @RequestMapping(value = "/supplier",method = {RequestMethod.POST,RequestMethod.GET})
    public String supplier(Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        String itemsJson=JSON.toJSONString(supplierMapper.listSupplierOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "Supplier";
    }
    @RequestMapping(value = "/supplier/{supplier_name}",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in(@PathVariable String supplier_name,Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        Supplier supplier=supplierMapper.querySupplierOfUserIdBySupplierName(id, supplier_name);
        if(supplier==null){
            supplier=new Supplier();
        }
        supplier.setSupplier_name(supplier_name);
        String itemsJson=JSON.toJSONString(supplier);
        model.addAttribute("data",itemsJson);
        return "SupplierDetail";
    }
    @RequestMapping(value = "/api/supplier/modify",method = {RequestMethod.POST,RequestMethod.GET})
    public String modify(
        @Parameter String supplier_name,
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
            return "redirect:/supplier/"+supplier_name+"?error";
        }
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication(). getName());
        if(id==null)
            id=0L;
        Supplier supplier=new Supplier(
            id,
            supplier_name,
            dateFormat,
            operator,
            mobilephone,
            telephone,
            address,
            comments
            );
        supplierMapper.addSupplier(supplier);
        
        return "redirect:/supplier?add=1";
    }
}
