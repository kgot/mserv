package com.kgottis.mserv.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kostas
 */
@Configuration
@EnableAutoConfiguration
public class AppBoot {
 
       public static void main(String[] args) {
            SpringApplication.run(AppBoot.class);
        }
     
}