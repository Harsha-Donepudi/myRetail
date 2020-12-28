package com.retail.myRetail;

import com.retail.myRetail.DataLayer.Price;
import com.retail.myRetail.DataLayer.RetailPriceService;
import com.retail.myRetail.DataLayer.RetailPriceServiceImpl;
import com.retail.myRetail.restservice.APIResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.assertEquals;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyRetailControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RetailPriceServiceImpl retailPriceServiceImpl;

    Price mockprice = new Price("1",11.00, "USD");
    String jsonupdatemock = "{\"id\":\"2\",\"value\":10.99,\"currency_code\":\"RPS\"}";
    APIResponse mockapiresponse = new APIResponse(1L,"Test", mockprice);

    @Test
    public void testApiResponse() throws Exception {

        Mockito.when(
                retailPriceServiceImpl.getById(Mockito.anyString())).thenReturn(mockprice);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/products/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        JSONAssert.assertEquals(mockapiresponse.toString(), result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void testupdateprice() throws Exception {

        Mockito.when(
                retailPriceServiceImpl.saveOrUpdate(mockprice)).thenReturn(mockprice);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                "/products/1").accept(MediaType.APPLICATION_JSON).content(jsonupdatemock).
                contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "Ok.";

        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());

        assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
