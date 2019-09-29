package com.example.resttemplate.resttemplateexample;

import com.example.resttemplate.resttemplateexample.config.PreAuthorizeValueProvider;
import com.example.resttemplate.resttemplateexample.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class RestTemplateExampleApplication {

    public static void main(String[] args) {
        //Locale.setDefault(new Locale("tr_TR"));
        SpringApplication.run(RestTemplateExampleApplication.class, args);

        PreAuthorizeValueProvider.getPreAuthorizeAnnotatedValues().stream().forEach(System.out::println);

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
