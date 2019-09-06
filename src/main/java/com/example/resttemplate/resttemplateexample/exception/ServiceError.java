package com.example.resttemplate.resttemplateexample.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ServiceError implements Serializable {

    private HttpStatus status;
    private Integer statusCode;
    private String errMessage;
    private String errCode;
    private String debugMessage;
    private String validatedField;
    private String language;
    private String label;

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

    public String getValidatedField() {
        return validatedField;
    }

    public void setValidatedField(String validatedField) {
        this.validatedField = validatedField;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ServiceError{" +
                "status=" + status +
                ", statusCode=" + statusCode +
                ", errMessage='" + errMessage + '\'' +
                ", errCode='" + errCode + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", validatedField='" + validatedField + '\'' +
                ", language='" + language + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
