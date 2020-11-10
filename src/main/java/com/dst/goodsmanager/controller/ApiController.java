package com.dst.goodsmanager.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Base64.Encoder;

import com.alibaba.fastjson.JSON;
import com.dst.goodsmanager.mapper.ItemMapper;
import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.mapper.TransitInMapper;
import com.dst.goodsmanager.mapper.TransitOutMapper;
import com.dst.goodsmanager.pojo.Item;
import com.dst.goodsmanager.pojo.SalerUser;
import com.dst.goodsmanager.pojo.TransitIn;
import com.dst.goodsmanager.pojo.TransitOut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import io.swagger.v3.oas.annotations.Parameter;
import net.coobird.thumbnailator.Thumbnails;

@Controller
public class ApiController {
    @Autowired
    private SalerUserMapper salerUserMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private TransitInMapper transitInMapper;
    @Autowired
    private TransitOutMapper transitOutMapper;
    @RequestMapping(value="/api/signup",method=RequestMethod.POST)
    public String signup(
        @Parameter String email,
        @Parameter String nickname,
        @Parameter String password
        ){

        SalerUser salerUser;

        salerUser=salerUserMapper.querySalerUserByUsername(email);
        if(salerUser!=null){
            return "redirect:/signup?error=duplicate";
        }

        salerUser=new SalerUser();
        salerUser.setUsername(email);
        salerUser.setPassword(SalerUser.encoder.encode(password));
        salerUser.setNickname(nickname);


        salerUserMapper.addSalerUser(salerUser);

        long id=salerUserMapper.getIdSalerUserByUsername(email);

        salerUser.setUsername_id(id);

        salerUserMapper.addSalerUserProfile(salerUser);
        // System.out.println(new Throwable().getStackTrace()[0]+":"+nickname+email+password+email);
        return "redirect:/slogin?sigup_success=1";
    }
    @RequestMapping(value="/api/item/add",method=RequestMethod.POST)
    public String itemAdd(
        @Parameter String barcode,
        @Parameter String product_name,
        @Parameter String profilephoto,
        @Parameter String date,
        @Parameter String price_in,
        @Parameter String price_out,
        @Parameter String amount,
        @Parameter String customer,
        @Parameter String operator,
        @Parameter String comments
        )
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");



        Date dateFormat; 
        try{
            dateFormat= formatter.parse(date);
        }catch(ParseException e){
            return "redirect:/additem?error";
        }
        
        Item item=new Item(SecurityContextHolder.getContext().getAuthentication()
                .getName()
                ,  barcode,  profilephoto,  product_name,  price_in,  price_out,  
                amount,  dateFormat,  operator,  customer,  comments);
        itemMapper.addItemOfUser(item);
        
        return "redirect:/items?add=1";
    }

    @RequestMapping(value="/api/transit_in/add",method=RequestMethod.POST)
    public String transit_inAdd(
        @Parameter String barcode,
        @Parameter String date,
        @Parameter String price_in,
        @Parameter long amount,
        @Parameter String supplier,
        @Parameter String location,
        @Parameter String operator,
        @Parameter String comments
        )
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        
        long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());

        Date dateFormat; 
        try{
            dateFormat= formatter.parse(date);
        }catch(ParseException e){
            return "redirect:/transit_in/add?error";
        }
        
        TransitIn item = new TransitIn(
                id
                ,  supplier,  barcode,  price_in,  amount,  location,  
                 dateFormat,  operator,  comments);
        System.out.println(new Throwable().getStackTrace()[0]+":"+item);
        transitInMapper.addTransitIn(item);
        
        return "redirect:/transit_in/add?add=1";
    }
    @RequestMapping(value="/api/transit_out/add",method=RequestMethod.POST)
    public String transit_outAdd(
        @Parameter String barcode,
        @Parameter String date,
        @Parameter String price_out,
        @Parameter long amount,
        @Parameter String buyer,
        @Parameter String location,
        @Parameter String operator,
        @Parameter String comments
        )
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        
        Long id=salerUserMapper.getIdSalerUserByUsername(
            SecurityContextHolder.getContext().getAuthentication().getName());

        

        Date dateFormat; 
        try{
            dateFormat= formatter.parse(date);
        }catch(ParseException e){
            return "redirect:/transit_out/add?error";
        }
        
        TransitOut item = new TransitOut(
                id
                ,  buyer,  barcode,  price_out,  amount,  location,  
                 dateFormat,  operator,  comments);
        System.out.println(new Throwable().getStackTrace()[0]+":"+item);
        transitOutMapper.addTransitOut(item);
        
        return "redirect:/transit_out/add?add=1";
    }
    @RequestMapping(value="/api/item/modify",method=RequestMethod.POST)
    public String itemMofify(
        @Parameter String barcode,
        @Parameter String product_name,
        @Parameter String profilephoto,
        @Parameter String date,
        @Parameter String price_in,
        @Parameter String price_out,
        @Parameter String amount,
        @Parameter String customer,
        @Parameter String operator,
        @Parameter String comments,
        @Parameter String modify,
        @Parameter String delete
        )
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String[] args={barcode,
            product_name,
            profilephoto,
            date,
            price_in,
            price_out,
            amount,
            customer,
            operator,
            comments,
            modify,
            delete};
        System.out.println(Arrays.toString(args));


        Date dateFormat; 
        try{
            dateFormat= formatter.parse(date);
        }catch(ParseException e){
            return "redirect:/modify?error=1";
        }
        
        Item item=new Item(SecurityContextHolder.getContext().getAuthentication()
                .getName()
                ,  barcode,  profilephoto,  product_name,  price_in,  price_out,  
                amount,  dateFormat,  operator,  customer,  comments);
        itemMapper.updateItemByBarcode(item);
        
        return "redirect:/items?modify=1";
    }









    @RequestMapping(value="/api/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(
        @RequestParam("img") MultipartFile file
        ){
        byte[] res=null;
        if(file==null)
            return "ERROR";
        try{
            ByteArrayOutputStream os=new ByteArrayOutputStream(); 
            Thumbnails.of(file.getInputStream()).size(60, 60).toOutputStream(os);
            Encoder encoder=Base64.getEncoder();
            res = encoder.encode(os.toByteArray());
        }
        catch(IOException e){
        }
        StringBuilder builder=new StringBuilder();
        for(byte x:res){
            builder.append((char) x);
        }
        System.out.println(new Throwable().getStackTrace()[0]+":"+builder.length());
        return "<img src=\"data:image/png;base64,"+builder+"\" /img>";
    }
    @RequestMapping(value="/api/test")
    @ResponseBody
    public String test(
        // @RequestParam("img") MultipartFile file
        ){
        String r=JSON.toJSONString(itemMapper.listItemOfUser("dst@1"));
        System.out.println(new Throwable().getStackTrace()[0]+":"+r);
         return "OK";
    }
}
