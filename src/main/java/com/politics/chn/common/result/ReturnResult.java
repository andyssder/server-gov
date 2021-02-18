package com.politics.chn.common.result;

import com.politics.chn.common.enums.ResultStatusEnum;

/**
 * @author: andyssder
 * @create: 2021-02-07 16:20
 */
public class ReturnResult<T> {
    private String code;
    private String message;
    private T data;

    public ReturnResult() {
    }

    public ReturnResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ReturnResult(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
    }

    public ReturnResult(ResultStatusEnum resultStatusEnum, T data) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static ReturnResult<Void> success() {
        return new ReturnResult<>(ResultStatusEnum.SUCCESS, null);
    }

    public static <T> ReturnResult<T> success(T data) {
        return new ReturnResult<>(ResultStatusEnum.SUCCESS, data);
    }

    public static <T> ReturnResult<T> success(ResultStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new ReturnResult<>(resultStatus, data);
    }

    public static <T> ReturnResult<T> failure() {
        return new ReturnResult<>(ResultStatusEnum.INTERNAL_SERVER_ERROR, null);
    }

    public static <T> ReturnResult<T> failure(String code, String message) {
        return new ReturnResult<>(code, message);
    }

    public static <T> ReturnResult<T> failure(ResultStatusEnum resultStatus) {
        return failure(resultStatus, null);
    }

    public static <T> ReturnResult<T> failure(ResultStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new ReturnResult<>(ResultStatusEnum.INTERNAL_SERVER_ERROR, null);
        }
        return new ReturnResult<>(resultStatus, data);
    }
}
