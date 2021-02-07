package com.politics.chn.common.config;

/**
 * @author: andyssder
 * @create: 2021-02-07 16:35
 */

import com.politics.chn.common.annotation.GlobalResultDisabled;
import com.politics.chn.common.result.ReturnResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * @author: andyssder
 * @create: 2021-02-07 17:14
 */
@EnableWebMvc
@Configuration
public class GlobalReturnConfig {

    @RestControllerAdvice
    private static class ResultResponseAdvice implements ResponseBodyAdvice<Object> {

        private static final Class<? extends Annotation> ANNOTATION_TYPE = GlobalResultDisabled.class;

        @Override
        public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
            return !AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) && !returnType.hasMethodAnnotation(ANNOTATION_TYPE);
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                      MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                      ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (body instanceof ReturnResult) {
                return body;
            }
            return ReturnResult.success(body);
        }
    }
}
