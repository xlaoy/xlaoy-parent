package com.xlaoy.starter.config;


import com.xlaoy.common.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * Created by Administrator on 2018/7/6 0006.
 */
@Component
@EnableCaching
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    private RedisSerializer<String> stringSerializer = new StringRedisSerializer();
    private GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer(JSONUtil.getObjectMapper());

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jsonRedisSerializer);

        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }


    @Bean
    public CacheManager cacheManager() {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        cacheConfiguration = cacheConfiguration.disableCachingNullValues();
        cacheConfiguration = cacheConfiguration.disableKeyPrefix();
        cacheConfiguration = cacheConfiguration.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer));
        cacheConfiguration = cacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer));

        RedisCacheWriter cacheWriter = new MyRedisCacheWriter(redisConnectionFactory);

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(cacheWriter);
        builder.cacheDefaults(cacheConfiguration);
        return builder.build();
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                if (objects.length == 0) {
                    return SimpleKey.EMPTY;
                } else {
                    StringBuilder sb = new StringBuilder("");
                    for (Object obj : objects) {
                        if("".equals(sb.toString())) {
                            sb.append(obj.toString());
                        } else {
                            sb.append("-" + obj.toString());
                        }
                    }
                    return sb.toString();
                }
            }
        };
    }
}
