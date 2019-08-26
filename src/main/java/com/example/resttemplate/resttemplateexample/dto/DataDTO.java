package com.example.resttemplate.resttemplateexample.dto;

import java.util.Date;

/**
 * @author Ramazan Karagöz
 * @date 8/26/2019
 */

public class DataDTO {

    private Double lastBuyPrice;
    private Double lastSellPrice;
    private Date lastUpdateDate;
    private Double todayLowestSellPrice;
    private Double todayHighestSellPrice;
    private Double yesterdayClosingSellPrice;
    private Double dailyChange;
    private Double dailyChangePercentage;

    public Double getLastBuyPrice() {
        return lastBuyPrice;
    }

    public void setLastBuyPrice(Double lastBuyPrice) {
        this.lastBuyPrice = lastBuyPrice;
    }

    public Double getLastSellPrice() {
        return lastSellPrice;
    }

    public void setLastSellPrice(Double lastSellPrice) {
        this.lastSellPrice = lastSellPrice;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Double getTodayLowestSellPrice() {
        return todayLowestSellPrice;
    }

    public void setTodayLowestSellPrice(Double todayLowestSellPrice) {
        this.todayLowestSellPrice = todayLowestSellPrice;
    }

    public Double getTodayHighestSellPrice() {
        return todayHighestSellPrice;
    }

    public void setTodayHighestSellPrice(Double todayHighestSellPrice) {
        this.todayHighestSellPrice = todayHighestSellPrice;
    }

    public Double getYesterdayClosingSellPrice() {
        return yesterdayClosingSellPrice;
    }

    public void setYesterdayClosingSellPrice(Double yesterdayClosingSellPrice) {
        this.yesterdayClosingSellPrice = yesterdayClosingSellPrice;
    }

    public Double getDailyChange() {
        return dailyChange;
    }

    public void setDailyChange(Double dailyChange) {
        this.dailyChange = dailyChange;
    }

    public Double getDailyChangePercentage() {
        return dailyChangePercentage;
    }

    public void setDailyChangePercentage(Double dailyChangePercentage) {
        this.dailyChangePercentage = dailyChangePercentage;
    }
}
