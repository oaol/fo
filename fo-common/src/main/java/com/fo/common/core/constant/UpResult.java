package com.fo.common.core.constant;

import com.fo.common.core.base.BaseResult;

public class UpResult<T> extends BaseResult<T> {

    public UpResult(UpResultConstant upResultConstant, T data) {
        super(upResultConstant.getCode(), upResultConstant.getMessage(), data);
    }

    public UpResult(T data) {
        super(UpResultConstant.SUCCESS.code, UpResultConstant.SUCCESS.message, data);
    }

    public UpResult() {
        super(UpResultConstant.SUCCESS.code, UpResultConstant.SUCCESS.message, null);
    }

}
