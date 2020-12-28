package com.retail.myRetail.consumerrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

  private Long id;
  private String name;

  public Value() {
  }

  public Long getId() {
    return this.id;
  }

  public String getname() {
    return this.name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setname(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Value{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}