package com.retail.myRetail.restservice.controllers;

import com.retail.myRetail.DataLayer.services.RetailPriceServiceImpl;
import com.retail.myRetail.restservice.APIResponse;
import com.retail.myRetail.restservice.HelperFunctions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.retail.myRetail.DataLayer.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRetailController {

    @Autowired
    private RetailPriceServiceImpl retailPriceServiceImpl;

    @Autowired
    private HelperFunctions helperFunctions;

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Object apiresponse(@PathVariable("id") String id) {
        if (helperFunctions.isLong(id)){
            Price current_price = retailPriceServiceImpl.getById(id);
            APIResponse apiResponse = new APIResponse(Long.parseLong(id), "Test", current_price);
            return apiResponse;
        } else {
            return "Enter right Id";
        }
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody Object updatePrice(@RequestBody Price price, @PathVariable("id") String id) {
        try {
            if (price.getId().equals(id)) {
                retailPriceServiceImpl.saveOrUpdate(price);
                return "Ok.";
            } else {
                return "Enter right ID corresponding to request Body.";
            }
        } catch (Exception e) {
            return "Enter Correct Data for Insertion/ Updating Price.";
        }

    }
    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
