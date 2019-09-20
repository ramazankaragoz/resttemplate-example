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
    private static final String HAS_AUTHORITY_VALUE_INDEX_PATTERN = "'";
    private static final String HAS_ANY_AUTHORITY_VALUE_PATTERN = "hasAnyAuthority|\\W";
    private static final String HAS_ANY_AUTHORITY_CONTAINS_VALUE="hasAnyAuthority";
    private static Set<String> values;

    private PreAuthorizeValueProvider() {
    }

    public static Set<String> getPreAuthorizeAnnotatedValues() {

        values = new HashSet<>();
        Reflections reflections = new Reflections(PACKAGE_NAME);
        Set<Class<?>> preAuthorizeClasses = reflections.getTypesAnnotatedWith(RestController.class);

        if (preAuthorizeClasses != null && !preAuthorizeClasses.isEmpty()) {
            for (Class aClass : preAuthorizeClasses) {
                List<Method> methods=Arrays.asList(aClass.getDeclaredMethods());
                values = getPreAuthorizeAnnotatedMethodValues(methods);
            }
        }

        return values;
    }

    /**
     * Method üzerinde @PreAuthorize annotation ile işaretlenmiş methodları bularak annotation değerlerini getirir.
     * @param methods
     * @return
     */
    private static Set<String> getPreAuthorizeAnnotatedMethodValues(List<Method> methods) {

        if (methods != null && !methods.isEmpty()) {
            for (Method method : methods) {
                if (method.getAnnotation(PreAuthorize.class) != null && method.getAnnotation(PreAuthorize.class).value() != null) {
                    values=modifyValue(method.getAnnotation(PreAuthorize.class).value());
                }
            }
        }

        return values;
    }

    /**
     * Parametredeki value değerini belirli pattern kullanarak düzenler ve values listesine ekler.
     * @param value
     * @return values
     */
    private static Set<String> modifyValue(String value) {

        if (value.contains(HAS_ANY_AUTHORITY_CONTAINS_VALUE)) {
            List<String> hasAnyAuthorityValues = Arrays.asList(value.trim().split(HAS_ANY_AUTHORITY_VALUE_PATTERN));
            hasAnyAuthorityValues = hasAnyAuthorityValues.stream().filter(s -> s.length() > 0).collect(Collectors.toList());
            for (String v : hasAnyAuthorityValues) {
                values.add(v);
            }
        } else {
            value = value.substring(value.indexOf(HAS_AUTHORITY_VALUE_INDEX_PATTERN) + 1, value.lastIndexOf(HAS_AUTHORITY_VALUE_INDEX_PATTERN));
            if (value.length() > 0)
                values.add(value);
        }

        return values;
    }

}
