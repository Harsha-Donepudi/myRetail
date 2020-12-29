package com.retail.myRetail.DataLayer.repositories;

import com.retail.myRetail.DataLayer.domain.Price;
import org.springframework.data.repository.CrudRepository;

public interface RetailPriceRepository extends CrudRepository<Price, String> {
}
