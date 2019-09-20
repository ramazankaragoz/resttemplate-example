package com.example.resttemplate.resttemplateexample.config;

import org.reflections.Reflections;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        values = new HashSet<>();
        Reflections reflections = new Reflections(PACKAGE_NAME);
        Set<Class<?>> preAuthorizeClasses = reflections.getTypesAnnotatedWith(RestController.class);

        if (preAuthorizeClasses != null && preAuthorizeClasses.size() > 0) {
            for (Class aClass : preAuthorizeClasses) {
                for (Method method : aClass.getMethods()) {
                    if (method.getAnnotation(PreAuthorize.class) != null && method.getAnnotation(PreAuthorize.class).value() != null) {
                        value = method.getAnnotation(PreAuthorize.class).value();
                        if (value.contains("hasAnyAuthority")) {
                            List<String> hasAnyAuthorityValues = Arrays.asList(value.trim().split("hasAnyAuthority|\\W"));
                            hasAnyAuthorityValues = hasAnyAuthorityValues.stream().filter(s -> s.length() > 0).collect(Collectors.toList());
                            for (String v : hasAnyAuthorityValues) {
                                values.add(v);
                            }
                        } else {
                            value = value.substring(value.indexOf(VALUE_INDEX_PATTERN) + 1, value.lastIndexOf(VALUE_INDEX_PATTERN));
                            if (value.length() > 0)
                                values.add(value);
                        }
                    }
                }
            }
        }

        return values;
    }

}
