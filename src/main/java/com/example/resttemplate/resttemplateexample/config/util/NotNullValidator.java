package com.example.resttemplate.resttemplateexample.config.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramazan Karagöz
 * @date 9/6/2019
 */

public class NotNullValidator implements ConstraintValidator<NotNull,Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (value!=null){
            return true;
        }

        return false;
    }
}
