package com.example.resttemplate.resttemplateexample.controller;

import com.example.resttemplate.resttemplateexample.service.RestService;
import com.example.resttemplate.resttemplateexample.dto.ExchangeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Ramazan Karagöz
 * @date 8/26/2019
 */
@RestController
@RequestMapping(value = "exchange")
public class ExchangeController {

    private RestService restService=new RestService();

    @GetMapping("/getCurrencies")
    public @ResponseBody ResponseEntity<List<ExchangeDTO>> getCurrencies(){

        try {
            return new ResponseEntity<List<ExchangeDTO>>(restService.getCurrency(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<List<ExchangeDTO>>((List<ExchangeDTO>) null,HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getGolds")
    public @ResponseBody ResponseEntity<List<ExchangeDTO>> getGolds(){

        try {
            return new ResponseEntity<List<ExchangeDTO>>(restService.getGold(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<List<ExchangeDTO>>((List<ExchangeDTO>) null,HttpStatus.NO_CONTENT);
        }
    }
}
