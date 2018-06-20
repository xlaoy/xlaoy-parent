package com.xlaoy.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/20 0020.
 */
public final class JSONUtil {

    private final static Logger logger = LoggerFactory.getLogger(JSONUtil.class);

    private final static ObjectMapper mapper = new ObjectMapper();

    static {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(Java8TimeUtil.YYYY_MM_DD_HH_MM_SS)));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(Java8TimeUtil.YYYY_MM_DD)));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(Java8TimeUtil.HH_MM_SS)));
        mapper.registerModule(javaTimeModule);
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static String toJsonString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.error("josn解析错误", e);
            return null;
        }
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return (T) mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.error("josn解析错误", e);
            return null;
        }
    }

    public static <T> List<T> fromJsonToList(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            logger.error("josn解析错误", e);
            return null;
        }
    }

    public static <K, V> Map<K, V> fromJsonToMap(String jsonString) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, new TypeReference<Map<K, V>>() {
            });
        } catch (IOException e) {
            logger.error("josn解析错误", e);
            return null;
        }
    }

    public static <K, V> Map<K, V> fromObjectToMap(Object object) {
        if (StringUtils.isEmpty(object)) {
            return null;
        }
        String jsonString = toJsonString(object);
        return fromJsonToMap(jsonString);

    }

    public static <T> T fromMapToObject(Map map, Class<T> clazz) {
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        String jsonString = toJsonString(map);
        return (T) fromJson(jsonString, clazz);

    }
}
