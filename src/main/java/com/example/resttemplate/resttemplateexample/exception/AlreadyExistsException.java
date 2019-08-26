package com.example.resttemplate.resttemplateexample.exception;

public class AlreadyExistsException extends BaseServiceException {

    public AlreadyExistsException(BaseExceptionEnum baseExceptionEnum) {
        super(baseExceptionEnum);
    }
}
