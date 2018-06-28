package com.xlaoy.common.support;

import com.xlaoy.common.exception.ExceptionResponse;
import com.xlaoy.common.utils.JSONUtil;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class JsonResponseWriter {

    private HttpServletResponse response;

    private ExceptionResponse exceptionResponse = new ExceptionResponse();

    public static JsonResponseWriter response(HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        JsonResponseWriter writer = new JsonResponseWriter();
        writer.setResponse(response);
        return writer;
    }

    private JsonResponseWriter setResponse(HttpServletResponse response) {
        this.response = response;
        return this;
    }

    public JsonResponseWriter status(HttpStatus httpStatus) {
        response.setStatus(httpStatus.value());
        exceptionResponse.setCode(httpStatus.value());
        return this;
    }

    public JsonResponseWriter message(String message) {
        exceptionResponse.setMessage(message);
        return this;
    }

    public void print() throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print(JSONUtil.toJsonString(exceptionResponse));
        writer.flush();
    }
}
