package com.example.resttemplate.resttemplateexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Locale;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class RestTemplateExampleApplication {

    public static void main(String[] args) {
        //Locale.setDefault(new Locale("tr_TR"));
        SpringApplication.run(RestTemplateExampleApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
