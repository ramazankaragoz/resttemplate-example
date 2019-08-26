package com.example.resttemplate.resttemplateexample.dto;

import com.example.resttemplate.resttemplateexample.dto.DataDTO;
import com.example.resttemplate.resttemplateexample.dto.MarketDTO;

/**
 * @author Ramazan Karagöz
 * @date 8/26/2019
 */

public class ExchangeDTO {
    private String code;
    private String name;
    private String type;
    private DataDTO data;
    private MarketDTO market;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public MarketDTO getMarket() {
        return market;
    }

    public void setMarket(MarketDTO market) {
        this.market = market;
    }
}
