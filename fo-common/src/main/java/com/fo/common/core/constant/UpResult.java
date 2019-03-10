package com.fo.common.core.constant;

import com.fo.common.core.base.BaseResult;

public class UpResult<T> extends BaseResult<T> {

    public UpResult(UpResultEnum upResultConstant, T data) {
        super(upResultConstant.getCode(), upResultConstant.getMessage(), data);
    }

    public UpResult(T data) {
        super(UpResultEnum.SUCCESS.code, UpResultEnum.SUCCESS.message, data);
    }

    public UpResult() {
        super(UpResultEnum.SUCCESS.code, UpResultEnum.SUCCESS.message, null);
    }

}
