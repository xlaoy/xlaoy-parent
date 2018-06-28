package com.xlaoy.common.exception;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ExceptionResponse implements Serializable{

    private Integer code;

    private String message;

    private Map<String, String> bizData;

    public ExceptionResponse() {

    }

    public ExceptionResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ExceptionResponse(Integer code, String message, Map<String, String> bizData) {
        this.code = code;
        this.message = message;
        this.bizData = bizData;
    }

}
