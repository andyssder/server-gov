package com.politics.chn.common.enums;

/**
 * @author andyssder
 * @create 2021-02-07 16:07
 */
public enum ResultStatusEnum {
    // 数据操作定义
    SUCCESS("200", "成功"),
    BAD_REQUEST("400", "请求错误，请修正请求"),
    NO_AUTH("401", "未经授权访问"),
    NO_PERMISSION("403", "拒绝访问"),
    NOT_FOUND("404", "无法找到资源"),
    METHOD_NOT_ALLOWED("405", "不支持当前请求方法"),
    INTERNAL_SERVER_ERROR("500", " 服务器运行异常"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!");

    private final String code;

    private final String message;

    ResultStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
