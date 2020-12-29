package com.retail.myRetail.DataLayer.services;

import com.retail.myRetail.DataLayer.domain.Price;

public interface RetailPriceService {
  Iterable<Price> listAll();
  Price getById(String id);
  Price saveOrUpdate(Price price);
}
