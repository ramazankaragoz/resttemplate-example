package com.example.resttemplate.resttemplateexample.config;

import org.reflections.Reflections;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @author Ramazan Karagöz
 * @date 9/19/2019
 */

public class PreAuthorizeValueProvider {

    private static final String PACKAGE_NAME = "com.example.resttemplate.resttemplateexample.controller";
    private static final String VALUE_INDEX_PATTERN = "'";
    private static Set<String> values;


    public static Set<String> getPreAuthorizeAnnotatedValues() {

        String value;
        values=new HashSet<>();
        Reflections reflections = new Reflections(PACKAGE_NAME);
        Set<Class<?>> preAuthorizeClasses = reflections.getTypesAnnotatedWith(RestController.class);

        if (preAuthorizeClasses!=null&&preAuthorizeClasses.size()>0) {
            for (Class aClass : preAuthorizeClasses) {
                for (Method method : aClass.getMethods()) {
                    if (method.getAnnotation(PreAuthorize.class) != null && method.getAnnotation(PreAuthorize.class).value() != null) {
                        value = method.getAnnotation(PreAuthorize.class).value();
                        values.add(value.substring(value.indexOf(VALUE_INDEX_PATTERN), value.lastIndexOf(VALUE_INDEX_PATTERN)));
                    }
                }
            }
        }

        return values;
    }

}
