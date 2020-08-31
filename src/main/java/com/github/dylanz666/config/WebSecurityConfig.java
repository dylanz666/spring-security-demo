package com.github.dylanz666.config;

import com.github.dylanz666.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author : dylanz
 * @since : 08/30/2020
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/home.html").permitAll()//这2个url不用访问认证
                .anyRequest().authenticated()//其他url都需要访问认证
                .and()
                .formLogin()
                .loginPage("/login.html")//登录页面的url
                .loginProcessingUrl("/login")//登录表使用的API
                .permitAll()//login.html和login不需要访问认证
                .and()
                .logout()
                .permitAll();//logout不需要访问认证
        httpSecurity.userDetailsService(userDetailsService());
        httpSecurity.userDetailsService(userDetailsService);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserDetails dylanz =
                User.withUsername("dylanz")
                        .password(bCryptPasswordEncoder.encode("666"))
                        .roles("ADMIN")
                        .build();
        UserDetails ritay =
                User.withUsername("ritay")
                        .password(bCryptPasswordEncoder.encode("888"))
                        .roles("USER")
                        .build();
        UserDetails jonathanw =
                User.withUsername("jonathanw")
                        .password(bCryptPasswordEncoder.encode("999"))
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(dylanz, ritay, jonathanw);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
