package com.retail.myRetail.DataLayer;

public interface RetailPriceService {
  Iterable<Price> listAll();
  Price getById(String id);
  Price saveOrUpdate(Price price);
}
