package com.fo.common.core.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fo.common.core.base.BaseResult;
import com.fo.common.core.constant.UpResultEnum;
import com.fo.common.core.exception.UpException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleMethodArgumentNotValidException(Exception e) {

        BaseResult<?> result = new BaseResult<>(UpResultEnum.FAIL.getCode(), null, null);
        if (e instanceof UpException) {
            result.setMessage(((UpException) e).getMessage());
        } else {
            result.setMessage(UpResultEnum.FAIL.getMessage());
        }
        return result;
    }

}