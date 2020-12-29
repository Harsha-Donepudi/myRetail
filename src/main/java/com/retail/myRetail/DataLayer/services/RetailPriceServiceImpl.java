package com.retail.myRetail.DataLayer.services;

import com.retail.myRetail.DataLayer.domain.Price;
import com.retail.myRetail.DataLayer.repositories.RetailPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailPriceServiceImpl implements RetailPriceService {

  private static final Logger logger = LoggerFactory.getLogger(RetailPriceServiceImpl.class);

  @Autowired
  private RetailPriceRepository retailPriceRepository;

  @Override
  public Iterable<Price> listAll() {
    return retailPriceRepository.findAll();
  }

  @Override
  public Price getById(String id) {
    return retailPriceRepository.findById(id).orElse(null);
  }

  @Override
  public Price saveOrUpdate(Price price) {
    retailPriceRepository.save(price);
    logger.info("Updated price data: " + price);
    return price;
  }
}
