package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.service.TestExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "testException")
public class TestExceptionController {

    private final TestExceptionService testExceptionService;

    @Autowired
    public TestExceptionController(TestExceptionService testExceptionService) {
        this.testExceptionService = testExceptionService;
    }

    @GetMapping("/findData")
    public void findData(){
        testExceptionService.findData();
    }

    @GetMapping("/saveData/{id}")
    public ResponseEntity<Long> saveData(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(testExceptionService.saveData(id), HttpStatus.OK);
    }
}
