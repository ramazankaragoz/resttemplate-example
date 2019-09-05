package com.example.resttemplate.resttemplateexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */
@Configuration
public class CustomMessageSourceConfig {

    private final DBMessageSource dbMessageSource;

    @Autowired
    public CustomMessageSourceConfig(DBMessageSource dbMessageSource) {
        this.dbMessageSource = dbMessageSource;
    }

    /*@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        return messageSource;
    }*/

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(dbMessageSource);
        return bean;
    }

}
