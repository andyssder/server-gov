package com.politics.chn.common.result;

import com.politics.chn.common.enums.sys.ResultStatusEnum;

import java.util.Objects;

/**
 * @since 2021-02-07
 * @author andyssder
 */
public class ReturnResult<T> {
    private String code;
    private String message;
    private Boolean success;
    private T data;

    public ReturnResult() {
    }

    public ReturnResult(String code, String message, Boolean success) {
        this(code, message, success, null);
    }

    public ReturnResult(String code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ReturnResult(ResultStatusEnum resultStatusEnum, Boolean success) {
        this(resultStatusEnum, success, null);
    }

    public ReturnResult(ResultStatusEnum resultStatusEnum, Boolean success, T data) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
        this.success = success;
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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static ReturnResult<Void> success() {
        return new ReturnResult<>(ResultStatusEnum.SUCCESS, true);
    }

    public static <T> ReturnResult<T> success(T data) {
        return new ReturnResult<>(ResultStatusEnum.SUCCESS, true, data);
    }

    public static <T> ReturnResult<T> success(ResultStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new ReturnResult<>(resultStatus, true, data);
    }

    public static <T> ReturnResult<T> failure() {
        return new ReturnResult<>(ResultStatusEnum.INTERNAL_SERVER_ERROR, false);
    }

    public static <T> ReturnResult<T> failure(String code, String message) {
        return new ReturnResult<>(code, message, false);
    }

    public static <T> ReturnResult<T> failure(ResultStatusEnum resultStatus) {
        return failure(resultStatus, null);
    }

    public static <T> ReturnResult<T> failure(ResultStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new ReturnResult<>(ResultStatusEnum.INTERNAL_SERVER_ERROR, false);
        }
        return new ReturnResult<>(resultStatus, false, data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReturnResult<?> that = (ReturnResult<?>) o;
        return Objects.equals(code, that.code) && Objects.equals(message, that.message) && Objects.equals(success, that.success) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, success, data);
    }

    @Override
    public String toString() {
        return "ReturnResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
