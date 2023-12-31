package com.truecaller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indicates it's a configuration class
public class SpringSecurity {
    @Order(1) // Order of Filtering Criteria, We can set multiple filtering criterias
    @Bean
    public SecurityFilterChain filteringCriteria(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().disable(); // Cross Origin Request Security
        httpSecurity.csrf().disable(); // Cross Site Request Forgery
        httpSecurity.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll()); // Write the logic for filtering
        // httpSecurity.authorizeHttpRequests(authorize -> authorize.requestMatchers("/auth/*").permitAll()); // API's Permitted
        // httpSecurity.authorizeHttpRequests(authorize -> authorize.requestMatchers("/order/*").authenticated()); // API's Authenticated
        return httpSecurity.build();
    }
    @Bean // Whatever this method would return would be present in the IOC Container as a Bean for Dependency Injection
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
