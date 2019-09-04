package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.dto.PersonDTO;
import com.example.resttemplate.resttemplateexample.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Ramazan Karagöz
 * @date 9/4/2019
 */

@RestController
@RequestMapping(value = "person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    protected ResponseEntity<PersonDTO> save(@Valid @RequestBody PersonDTO personDTO){

        return new ResponseEntity<>(personService.save(personDTO), HttpStatus.OK);
    }

}
