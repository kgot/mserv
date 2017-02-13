/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author kostas
 */
@Configuration
@ComponentScan
@EnableConfigurationProperties
@EnableJpaRepositories("com.kgottis.mserv.persistence")
@EnableTransactionManagement
@ConfigurationProperties(prefix = "spring")
@Profile("dev")
public class JPAConfig {

    @Value("${jpa.hibernate.ddl-auto}")
    private String ddl_auto;

    @Value("${jpa.hibernate.dialect}")
    private String dialect;

    @Value("${jpa.hibernate.naming-strategy}")
    private String naming_strategy;

    @Value("${jpa.hibernate.show_sql}")
    private String show_sql;

    @Value("${jpa.hibernate.format_sql}")
    private String format_sql;

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        hibernateJpa.setDatabasePlatform(dialect);
        hibernateJpa.setGenerateDdl(Boolean.valueOf(ddl_auto));
        hibernateJpa.setShowSql(Boolean.valueOf(show_sql));

        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put("javax.persistence.validation.mode", "none");

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.kgottis.mserv.domain");
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(hibernateJpa);
        emf.setJpaPropertyMap(jpaProperties);

        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txnMgr = new JpaTransactionManager();

        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());

        return txnMgr;
    }

}
