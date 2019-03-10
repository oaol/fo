package com.fo.common.core.constant;

/**
 * up系统接口结果常量枚举类
 */
public enum UpResultEnum {
    /** 成功 */
    SUCCESS("9000", "成功"),
    /** 成功 */
    FALLBACK("8000", "FALL_BACK"),
    /** 参数校验失败**/
    VALIDATION_FAIL("3000", "参数校验失败"),
    /** 失败 */
    FAIL("4000", "失败"),

    /** 重复请求 */
    REPEAT_REQUEST("5000", "重复请求"),

    /** 请求限流 */
    REQUEST_LIMIT("6000", "请求限流"),
    ;

    public String code;

    public String message;

    UpResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
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

}
