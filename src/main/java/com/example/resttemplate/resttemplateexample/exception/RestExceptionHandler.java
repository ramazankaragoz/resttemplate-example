package com.example.resttemplate.resttemplateexample.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER= LoggerFactory.getLogger("ASYNC_JSON_FILE_APPENDER");

    private final int HTTP_STATUS_VALUE=500;

    @ExceptionHandler({
            AlreadyExistsException.class
            ,DataNotFoundException.class})
    public ResponseEntity<Object> handleException(BaseServiceException ex){

        ServiceError serviceError=new ServiceError();
        serviceError.setErrCode(ex.getBaseExceptionEnum().getCode());
        serviceError.setErrMessage(ex.getMessage());
        serviceError.setStatus(HttpStatus.valueOf(HTTP_STATUS_VALUE));
        serviceError.setStatusCode(HTTP_STATUS_VALUE);
        LOGGER.info(serviceError.toString());
        ex.printStackTrace();
        return new ResponseEntity<>(serviceError, serviceError.getStatus());

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Locale.setDefault(new Locale("en"));
        LocaleContextHolder.setDefaultLocale(new Locale("en"));
        Locale localeContext = LocaleContextHolder.getLocale();
        Locale locale=request.getLocale();
        List<ServiceError> serviceErrors=new ArrayList<>();


        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            ServiceError serviceError=new ServiceError();
            serviceError.setStatusCode(status.value());
            serviceError.setStatus(status);
            serviceError.setErrCode(fieldError.getCode());
            serviceError.setErrMessage(fieldError.getDefaultMessage());
            serviceError.setValidatedField(fieldError.getField());
            serviceError.setLanguage(locale.getLanguage()+" Context lang:  "+localeContext.getLanguage());
            serviceErrors.add(serviceError);
            //System.out.println(fieldError.getField()+" "+fieldError.getDefaultMessage()+" "+fieldError.getCode());
        }
        return  new ResponseEntity<>(serviceErrors, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> onConstraintValidationException(ConstraintViolationException ex, WebRequest webRequest) {

            ServiceError serviceError=new ServiceError();
            serviceError.setStatusCode(500);
            serviceError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceError.setErrCode(String.valueOf(ex.getErrorCode()));
            serviceError.setErrMessage(ex.getCause().getMessage().substring(0,ex.getCause().getMessage().indexOf(";")));
            serviceError.setLanguage(webRequest.getLocale().getLanguage());
            serviceError.setDebugMessage(ex.getCause().getMessage());
            serviceError.setValidatedField(serviceError.getErrMessage().substring(serviceError.getErrMessage().indexOf("\"")+1,serviceError.getErrMessage().lastIndexOf("\"")));
            //System.out.println(fieldError.getField()+" "+fieldError.getDefaultMessage()+" "+fieldError.getCode());

        return  new ResponseEntity<>(serviceError, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
