package com.example.resttemplate.resttemplateexample.exception;

public class DataNotFoundException extends BaseServiceException {
    public DataNotFoundException(BaseExceptionEnum baseExceptionEnum) {
        super(baseExceptionEnum);
    }
}
