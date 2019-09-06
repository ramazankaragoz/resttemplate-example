package com.example.resttemplate.resttemplateexample.config.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramazan Karagöz
 * @date 9/6/2019
 */
public class TcNoValidator implements ConstraintValidator<TcNo,Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
       return ValidationUtil.tcNoValidation(value);
    }


}
