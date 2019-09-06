package com.example.resttemplate.resttemplateexample.config.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramazan Karagöz
 * @date 9/6/2019
 */

public class SizeValidator implements ConstraintValidator<Size,String> {

    private int min;
    private int max;

    @Override
    public void initialize(Size constraintAnnotation) {
        this.min=constraintAnnotation.min();
        this.max=constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value!=null&&value.length()<=max&&value.length()>=min){
            return true;
        }

        return false;
    }
}
