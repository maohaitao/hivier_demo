package com.bike.bananacard.common.constant;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/8
 * time: 下午3:40
 * description: 业务返回码
 */
public enum ErrorCode {
    SUCCESS(0, "成功"),
    SYSTEM_INTERNAL_ERROR(1000, "系统内部错误"),
    TOKEN_INVALID(1001, "令牌无效"),
    VALIDATION_FAIL(1002, "验证失败"),
    MISSING_PARAMETER(1006, "缺少参数"),
    PARAMETERS_INCORRECT(1007, "参数不正确"),
    REQUEST_INCORRECT(1010, "请求不合法"),
    DATA_REPEAT(1011, "数据重复"),
    DATA_NOT_EXIST(1012, "数据不存在"),
    INTERNAL_SERVICE_TIMEOUT(1020, "内部服务超时"),
    DEFINTION_USED(1030, "卡片已存在"),
    BLACK_USER(2001, "封号用户"),
    CHALLENGE_OVERTIME(2002,"挑战过期");


    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
