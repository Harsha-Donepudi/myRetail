package com.retail.myRetail.consumerrest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MyRetailRestTemplateClient {
    public static Value getName(String id) {
        final String uri = "https://api.target.com/products/v3/13860428?fields=descriptions&" +
                "id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";
        RestTemplate restTemplate = new RestTemplate();

        Value result = restTemplate.getForObject(uri, Value.class);

        return result;
        //Use the response
    }
}
