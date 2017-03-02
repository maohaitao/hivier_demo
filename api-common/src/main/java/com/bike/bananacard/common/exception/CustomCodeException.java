package com.bike.bananacard.common.exception;


import com.bike.bananacard.common.constant.ErrorCode;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/8
 * time: 下午3:40
 * description: 自定义业务代码异常
 */
public class CustomCodeException extends RuntimeException {
    private static final long serialVersionUID = 4572186403059322650L;
    private ErrorCode errorCode;

    public CustomCodeException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public CustomCodeException(ErrorCode errorCode, String field, String splice) {
        super(field + splice + errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public CustomCodeException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
