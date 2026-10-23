package com.onedao.devtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

 /*   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

       return http
                .formLogin( httpForm -> {
                    httpForm.loginPage("/login").permitAll();})
                .authorizeHttpRequests(reg -> {
                    reg.requestMatchers("/reg/signup").permitAll();
                    reg.anyRequest().authenticated();
                })

                .build();
    }*/


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user = User
                .withUsername("test")
                .password("{noop}test123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(req -> req.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }


}
