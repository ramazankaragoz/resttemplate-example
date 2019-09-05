package com.example.resttemplate.resttemplateexample.config;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Ramazan Karagöz
 * @date 9/5/2019
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = IpAddressValidator.class)
@Documented
public @interface IpAddress {

    String message() default "";

    String label() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
