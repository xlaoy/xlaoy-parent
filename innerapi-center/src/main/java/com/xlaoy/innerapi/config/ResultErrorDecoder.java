package com.xlaoy.innerapi.config;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public class ResultErrorDecoder implements ErrorDecoder {

    private Logger logger = LoggerFactory.getLogger(ResultErrorDecoder.class);

    /**
     * 对于restful抛出的4xx的错误，也许大部分是业务异常，并不是服务提供方的异常
     * 因此在进行feign client调用的时候，需要进行errorDecoder去处理，
     * 适配为HystrixBadRequestException，好避开circuit breaker的统计，否则就容易误判
     * @param methodKey
     * @param response
     * @return
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        FeignException feignException = FeignException.errorStatus(methodKey, response);
        logger.error("feign异常", feignException);
        if(response.status() >= 400 && response.status() <= 500){
            return new HystrixBadRequestException("feign response status " + response.status());
        }
        return feignException;
    }
}
