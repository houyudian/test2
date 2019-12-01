package com.fh.utils;

public enum ServerEnum {
    LOGIN_PHONEORCODE_INNULL(10000,"手机号或者验证码为空了"),
    LOGIN_CODE_ERROR(10001,"手机验证码输入有误"),
    LOGIN_SUCCESS(5003,"登陆成功"),
    LOGIN_EXPIRED(5004,"登录超时，请重新登陆"),

    ACCOUNT_OR_RWD_ISNULL(1001,"账号或密码不正确"),
    ACCOUNT_NOT_EXIST(1002,"账号不存在"),
    ACCOUNT_NOT_INVALID(1003,"账号无效"),
    PWD_ERROR(1004,"密码输入有误"),
    PERMISSION_NO(1005,"该用户没有权限"),

    ERROR(500,"失败"),
    ACCOUNT_ERROR(5001,"账号异常"),
    TOKEN_TIMEOUT(5006,"登录失效，请重新登录"),
    PHONE_ISNULL(5007,"手机号不能为空"),





    EXPORT_NULL(7001,"导出的数据为空"),

    EXAMINE_DATE_ERROR(8001,"请假时间选着有吴"),
    APPROVAL_NO_RIGHT(8002,"没有权限审批"),
    SESSION_TIMEOUT(8003,"没有权限审批"),
    PERMISSION_NO_ACCESS(8004,"没有权限"),

    SAFETY_ERROR(9000,"接口验签失败"),
    SERVER_CONNECT_ERROR(9001,"连接的服务器超时"),
    SERVER_BUSYNESS(9002,"服务器繁忙"),
    SERVER_ERROR(9003,"服务器未知异常"),
    SERVER_STOP(8005,"服务连接不上"),
    SERVER_TIMEOUT(8006,"服务连接请求超时"),



    SUCCESS(200,"成功")

            ;

    private Integer code;
    private String message;

    private ServerEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
