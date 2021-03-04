package com.vignesh;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class EbiConfigure extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/person").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/person").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/person").hasRole("ADMIN").and()
                .csrf().disable();
    }
}
