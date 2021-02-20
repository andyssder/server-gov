package com.politics.chn.common.exception;

import com.politics.chn.common.enums.ResultStatusEnum;

/**
 * @author andyssder
 * @create 2021-02-07 17:58
 */
public class CommonException extends RuntimeException{

    protected String errorCode;
    protected String errorMsg;

    public CommonException() {
        super();
    }

    public CommonException(ResultStatusEnum resultStatusEnum) {
        this(String.valueOf(resultStatusEnum.getCode()), resultStatusEnum.getMessage());
    }

    public CommonException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public CommonException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
