package com.fo.up.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fo.common.core.exception.FoException;

/**
 * common exception
 * @author bryce
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UpException extends FoException {

    private static final long serialVersionUID = 1L;
    
    private int code;
    private String errorMessage;
    
    public UpException(String message, Throwable cause) {
        super(message, cause);
        this.code = 400;
    }

    public UpException(String message) {
        super(message);
        this.code = 400;
    }

    public UpException(int code, String message) {
        super(message);
        this.code = code;
    }

    public UpException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
