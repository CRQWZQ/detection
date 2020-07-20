package com.example.demo.exception;

/**
 *
 * @Description: 业务异常<br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 */
public class BusinessException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public BusinessException(Throwable cause, String errorCode, String errorMessage) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "|BusinessException|errorCode=" + errorCode + "|errorMessage=" + errorMessage;
    }

    @Override
    public String getMessage() {
        return "|BusinessException|errorCode=" + errorCode + "|errorMessage=" + errorMessage;
    }
}
