package com.example.resttemplate.resttemplateexample.config.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramazan Karagöz
 * @date 9/6/2019
 */

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidationUtil.phoneNumberValidation(value);
    }
}
