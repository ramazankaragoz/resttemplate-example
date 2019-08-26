package com.example.resttemplate.resttemplateexample.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AlreadyExistsException.class,DataNotFoundException.class})
    public ResponseEntity<Object> handleException(BaseServiceException ex){

        ServiceError serviceError=new ServiceError();
        serviceError.setErrCode(ex.getBaseExceptionEnum().getCode());
        serviceError.setErrMessage(ex.getMessage());
        serviceError.setStatus(HttpStatus.valueOf(500));
        serviceError.setDebugMessage(ex.getLocalizedMessage());
        return new ResponseEntity<>(serviceError, serviceError.getStatus());

    }


}
