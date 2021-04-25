package com.politics.chn.common.exception;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.result.ReturnResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @since 2021-02-07
 * @author andyssder
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public ReturnResult commonExceptionHandler(CommonException e){
        e.printStackTrace();
        return ReturnResult.failure(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ReturnResult badCredentialsExceptionHandler(BadCredentialsException e){
        e.printStackTrace();
        return ReturnResult.failure(ResultStatusEnum.BAD_REQUEST.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ReturnResult exceptionHandler(Exception e) {
        e.printStackTrace();
        return ReturnResult.failure(ResultStatusEnum.INTERNAL_SERVER_ERROR);
    }
}
