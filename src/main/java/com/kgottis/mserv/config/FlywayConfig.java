package com.kgottis.mserv.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Flyway migration tool configuration.
 *
 * Created by kostas on 25/11/2016.
 */
@Configuration
@ComponentScan
@Profile("dev")
public class FlywayConfig {

    @Value("${flyway.baselineOnMigrate}")
    private Boolean baselineOnMigrate;

    @Value("${flyway.validateOnMigrate}")
    private Boolean validateOnMigrate;

    @Autowired
    private DataSource dataSource;

    @Bean
    public Flyway flyway() {
        Flyway flyway = new Flyway();

        flyway.setDataSource(dataSource);
        flyway.setValidateOnMigrate(validateOnMigrate);
        flyway.setBaselineOnMigrate(baselineOnMigrate);
        flyway.migrate();

        return flyway;
    }
}
