package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.dto.ExchangeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @author Ramazan Karagöz
 * @date 8/26/2019
 */
@Service
public class RestService {

    private final String CURRENCY_URL="https://api.canlidoviz.com/items/latest-data?marketId=0&type=CURRENCY";
    private final String GOLD_URL="https://api.canlidoviz.com/items/latest-data?marketId=0&type=GOLD";
    private RestTemplate restTemplate;
    private ObjectMapper mapper;

    public RestService(){
        mapper=new ObjectMapper();
        restTemplate=new RestTemplate();
    }

    public List<ExchangeDTO> getCurrency() throws IOException {

        ResponseEntity<List<ExchangeDTO>> responseEntity= restTemplate.exchange(CURRENCY_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<ExchangeDTO>>(){});

        List<ExchangeDTO> currencyList=responseEntity.getBody();

        //JsonNode root = mapper.readTree(responseEntity.getBody());
        //JsonNode code = root.path("code");
        //System.out.println(root.get(0).get("code"));

        return currencyList;
    }

    public List<ExchangeDTO> getGold() throws IOException {

        ResponseEntity<List<ExchangeDTO>> responseEntity= restTemplate.exchange(GOLD_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<ExchangeDTO>>(){});

        List<ExchangeDTO> goldList=responseEntity.getBody();

        return goldList;
    }
}
