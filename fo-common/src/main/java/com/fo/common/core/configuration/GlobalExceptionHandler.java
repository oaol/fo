package com.fo.common.core.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fo.common.core.exception.FoException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("inner error!");
    }

    @ExceptionHandler(FoException.class)
    public ResponseEntity<?> handleFoException(Exception e) {
        log.info(((FoException) e).getErrorMessage() == null ? e.getMessage() : ((FoException) e).getErrorMessage(), e);
        Map<String, Object> result = getErrorResponse(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    private Map<String, Object> getErrorResponse(Exception e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", ((FoException) e).getCode());
        result.put("message", e.getMessage());
        return result;
    }

}