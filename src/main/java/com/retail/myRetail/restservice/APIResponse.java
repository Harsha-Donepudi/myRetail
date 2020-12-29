package com.retail.myRetail.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.retail.myRetail.DataLayer.domain.Price;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {

    private Long id;
    private String name;
    private Price current_price;

    public Long getId() {
        return id;
    }

    public Price getCurrent_price() {
        return current_price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrent_price(Price current_price) {
        this.current_price = current_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public APIResponse(Long id, String name, Price current_price) {
        this.id = id;
        this.current_price = current_price;
        this.name = name;
    }

}
