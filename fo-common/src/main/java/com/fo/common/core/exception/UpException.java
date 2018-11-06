package com.fo.common.core.exception;

/**
 * common exception
 * @author bryce
 *
 */
public class UpException extends RuntimeException {

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
