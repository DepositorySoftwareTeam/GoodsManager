package com.dst.goodsmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.dst.goodsmanager.mapper.SalerUserMapper;
import com.dst.goodsmanager.pojo.SalerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
@Service
public class SalerUserDetailsService implements UserDetailsService {
	@Autowired
	SalerUserMapper salerUserMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 	throw new UsernameNotFoundException("用户名或密码错误");
		SalerUser user=salerUserMapper.querySalerUserByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException(username);
		}
		return new User(
            user.getUsername(), 
            user.getPassword(), 
            user.isEnabled(), 
            true,
            true,
            true,
            getGrantedAuthority());
	}
	public List<GrantedAuthority> getGrantedAuthority(){
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("SALER"));
		return list;
	}
}