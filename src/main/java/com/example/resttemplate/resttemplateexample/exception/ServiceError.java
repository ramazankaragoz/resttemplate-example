package com.example.resttemplate.resttemplateexample.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ServiceError implements Serializable {

    private HttpStatus status;
    private Integer statusCode;
    private String errMessage;
    private String errCode;
    private String debugMessage;


    public ServiceError(){

    }

    public ServiceError(HttpStatus status) {
        this.status = status;
    }

    public ServiceError(HttpStatus status, Throwable ex) {
        this.status = status;
        this.errMessage = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ServiceError(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.errMessage = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
