package com.xlaoy.common.exception;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
public class BizException extends RuntimeException {

    private String errorKey;

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String errorKey, String message) {
        super(message);
        this.errorKey = errorKey;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }
}
