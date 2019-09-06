package com.example.resttemplate.resttemplateexample.config.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramazan Karagöz
 * @date 9/5/2019
 */
public class IpAddressValidator implements ConstraintValidator<IpAddress,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       return ValidationUtil.ipAddressValidation(value);
    }

}
