package com.xlaoy.starter.config;


/**
 * Created by Administrator on 2018/7/6 0006.
 */
//@Component
public class RedisConfig {

    //@Autowired
    //private ReactiveRedisConnectionFactory reactiveRedisConnectionFactory;

    /*@Bean
    public ReactiveRedisTemplate reactiveRedisTemplate() {

        RedisSerializer stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer(JSONUtil.getObjectMapper());

        RedisSerializationContext serializationContext = RedisSerializationContext
                .newSerializationContext()
                .key(stringSerializer)
                .value(jsonRedisSerializer)
                .hashKey(stringSerializer)
                .hashValue(jsonRedisSerializer)
                .build();
        ReactiveRedisTemplate reactiveRedisTemplate = new ReactiveRedisTemplate(reactiveRedisConnectionFactory, serializationContext);
        return reactiveRedisTemplate;
    }*/
}
