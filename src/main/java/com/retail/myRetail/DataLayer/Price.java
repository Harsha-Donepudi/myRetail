package com.retail.myRetail.DataLayer;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    @Id
    public String id;

    private double value;
    private String currency_code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public Price(String id, double value, String currency_code) {
        this.id = id;
        this.value = value;
        this.currency_code = currency_code;
    }

    @Override
    public String toString() {
        return "current_price{" +
                "value=" + value +
                ", currency_code='" + currency_code + '\'' +
                '}';
    }
}
