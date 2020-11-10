package com.dst.goodsmanager.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.GoodsMapper;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.pojo.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Parameter;
import net.coobird.thumbnailator.Thumbnails;
@Controller
public class GoodsController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @RequestMapping(value = "/api/goods/add",method = {RequestMethod.POST})
    public String api_goods_add(
        @Parameter String barcode,
        @RequestParam("good_photo") MultipartFile file,
        @Parameter String goodname
    ){
        byte[] res=null;
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        
        
        try{
            ByteArrayOutputStream os=new ByteArrayOutputStream(); 
            Thumbnails.of(file.getInputStream()).size(40, 40).toOutputStream(os);
            Encoder encoder=Base64.getEncoder();
            res = encoder.encode(os.toByteArray());
        }
        catch(IOException e){
        }
        StringBuilder builder=new StringBuilder();
        if(res!=null){
            for(byte x:res){
                builder.append((char) x);
            }
        }
        String photoBase64=builder.toString();
        Goods goods=new Goods(id,barcode,goodname,photoBase64);
        if(photoBase64.length()<4){
            goodsMapper.addGoods(goods);
        }else goodsMapper.addGoodsWithPhoto(goods);
        return "redirect:/goods?add=1";
    }
    @RequestMapping(value = "/goods/add",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in_add(){
        return "GoodsAdd";
    }
    @RequestMapping(value = "/goods",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in(Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication(). getName());
        if(id==null)
            id=0L;
        String itemsJson=JSON.toJSONString(goodsMapper.listGoodsOfUserId(id));
        model.addAttribute("data",itemsJson);
        return "Goods";
    }
    @RequestMapping(value = "/goods/{barcode}",method = {RequestMethod.POST,RequestMethod.GET})
    public String transit_in(@PathVariable String barcode,Model model){
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());
        if(id==null)
            id=0L;
        Goods goods=goodsMapper.queryGoodsOfUserIdByBarcode(id, barcode);
        if(goods==null){
            goods=new Goods();
        }
        goods.setBarcode(barcode);
        String itemsJson=JSON.toJSONString(goods);
        model.addAttribute("data",itemsJson);
        return "GoodsDetail";
    }
}
