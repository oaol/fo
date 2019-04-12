package com.fo.common.core.exception;

import java.io.Serializable;

/**
 * common exception
 * @author bryce
 *
 */
public class FoException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1L;
    private int code;
    private String errorMessage;
    
    public FoException(String message, Throwable cause) {
        super(message, cause);
        this.code = 400;
    }

    public FoException(String message) {
        super(message);
        this.code = 400;
    }

    public FoException(int code, String message) {
        super(message);
        this.code = code;
    }

    public FoException() {
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
