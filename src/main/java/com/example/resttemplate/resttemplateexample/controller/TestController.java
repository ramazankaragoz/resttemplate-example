package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.entity.ApplicationUser;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Ramazan Karagöz
 * @date 9/3/2019
 */

@RestController
@RequestMapping(value = "test")
public class TestController {


    @PostMapping
    public String getAppUserFirstName(@RequestBody ApplicationUser applicationUser){

        return Optional.ofNullable(applicationUser.getFirstName()).orElse(new String());

    }
}
