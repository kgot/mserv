/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.config;

import com.kgottis.mserv.domain.KinoDraw;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author kostas
 */
@Configuration
@ComponentScan
@EnableCaching
@ConfigurationProperties(prefix = "spring")
@Profile("dev")
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.pass}")
    private String redisPass;

    /**
     * lettuce
     *
     * @return RedisConnectionFactory bean
     */
    @Bean
    public RedisConnectionFactory lettuceConnectionFactory() {
        LettuceConnectionFactory lcf = new LettuceConnectionFactory(redisHost, redisPort);
        lcf.setPassword(redisPass);
        return lcf;
    }

    @Bean
    public RedisOperations<Object, Object> redisOperations(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setHashKeySerializer(new GenericToStringSerializer<>(Long.class));
        template.setHashValueSerializer(kinoDrawRedisSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setEnableTransactionSupport(true);
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new GenericToStringSerializer<>(Object.class));
        template.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
        template.setValueSerializer(kinoDrawRedisSerializer());
        template.setHashValueSerializer(kinoDrawRedisSerializer());
        return template;
    }

    @Bean
    public RedisSerializer<KinoDraw> kinoDrawRedisSerializer() {
        return new Jackson2JsonRedisSerializer<>(KinoDraw.class);
    }

    @Bean
    CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }
}
