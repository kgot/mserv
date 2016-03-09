/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 * @author kostas
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.kgottis.mserv.persistence"})
@PropertySource("classpath:/db/dev/mongodb.yml")
//@Profile("dev")
public class AppConfigMongoDB {

    @Autowired
    private Environment env;

    @Value("${mongodb.url}")
    private String mongodbUrl;

    @Value("${mongodb.db}")
    private String defaultDb;

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

//        String mongodbUrl = env.getProperty("mongodb.url");
//        String defaultDb = env.getProperty("mongodb.db");

        MongoClientOptions mongoOptions = new MongoClientOptions.Builder().maxWaitTime(1000 * 60 * 5).build();
        MongoClient mongo = new MongoClient(mongodbUrl, mongoOptions);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, defaultDb);
        return new MongoTemplate(mongoDbFactory);
    }

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
