package com.fo.up.core.base;

/**
 * 统一返回结果类 Created by shuzheng on 2017/2/18.
 */
public class BaseResult<T> {

    /**
     * 状态码：1成功，其他为失败
     */
    public int code;

    /**
     * 成功为success，其他为失败原因
     */
    public String message;

    /**
     * 数据结果集
     */
    public T results;

    public BaseResult(int code, String message, T results) {
        this.code = code;
        this.message = message;
        this.results = results;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

}
