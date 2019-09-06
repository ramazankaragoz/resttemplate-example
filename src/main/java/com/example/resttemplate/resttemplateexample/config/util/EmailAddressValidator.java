package com.example.resttemplate.resttemplateexample.config.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramazan Karagöz
 * @date 9/6/2019
 */

public class EmailAddressValidator implements ConstraintValidator<EmailAddress,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidationUtil.emailAddressValidation(value);
    }
}
