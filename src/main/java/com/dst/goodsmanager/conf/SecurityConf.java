package com.dst.goodsmanager.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dst.goodsmanager.pojo.SalerUser;
import com.dst.goodsmanager.service.SalerUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return SalerUser.encoder;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new DeniedHandler();
    }

    @Autowired
    AccessDeniedHandler deniedHandler;

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        // super.configure(security);
        security.authorizeRequests()
            .antMatchers(new String[]{
                "/goods*",
                "/trans*",
                "/stock*",
                "/providers*"
            }).hasAuthority("SALER")
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().loginProcessingUrl("/api/login").failureForwardUrl("/jump/login")
            .and().logout().logoutUrl("/api/logout").logoutSuccessUrl("/slogin")
            .and().exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint(){
				@Override
				public void commence(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException authException) throws IOException, ServletException {
                    response.sendRedirect("/slogin?errorRole");
				}
            })
            // .accessDeniedHandler(deniedHandler)
            ;
        // security.exceptionHandling().accessDeniedPage("/slogin").and();
        // security;
        // security.logout().logoutSuccessUrl("/");
    }
    // @Override
    // protected void configure(AuthenticationManagerBuilder builder) throws Exception{
    //     builder.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).user(passwordManager)
    //     .withUser("manager@xxx").password(new BCryptPasswordEncoder().encode("123456")).roles("saler");
    // }
    @Autowired
	public SalerUserDetailsService salerUserDetailsService;
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(salerUserDetailsService);
    }
}
 