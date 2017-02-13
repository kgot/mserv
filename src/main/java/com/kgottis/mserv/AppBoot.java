package com.kgottis.mserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kostas
 */
@SpringBootApplication
@EnableScheduling
public class AppBoot {

    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class);
    }

}