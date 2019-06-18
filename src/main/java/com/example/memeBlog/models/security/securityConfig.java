package com.example.memeBlog.models.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                //.antMatchers("/", "/login", "/register").permitAll()
                //.antMatchers("/home").authenticated()
                .anyRequest().permitAll();
        //.and()
        //.formLogin()
        //.loginPage("/login").permitAll()
        //.usernameParameter("username")
        //.passwordParameter("password")
        //.and();
        http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}