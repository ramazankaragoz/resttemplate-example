package com.example.resttemplate.resttemplateexample.exception;

public class BaseServiceException extends RuntimeException {

    private BaseExceptionEnum baseExceptionEnum;

    public BaseServiceException(){

    }

    public BaseServiceException(BaseExceptionEnum baseExceptionEnum){
        super(baseExceptionEnum.getValue());
        this.baseExceptionEnum=baseExceptionEnum;
    }


    public BaseExceptionEnum getBaseExceptionEnum() {
        return baseExceptionEnum;
    }
}
