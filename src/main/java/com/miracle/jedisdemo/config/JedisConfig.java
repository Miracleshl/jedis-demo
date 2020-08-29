package com.miracle.jedisdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author QianShuang
 */
@Configuration
public class JedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Bean
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(host,port);
        return jedisPool;
    }
}
