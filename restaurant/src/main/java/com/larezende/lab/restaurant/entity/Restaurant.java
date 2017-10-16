package com.larezende.lab.restaurant.entity;


import com.larezende.lab.libs.entity.BaseEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant extends BaseEntity<String> {

  private List<Table> tables = new ArrayList<Table>();

  public Restaurant(String name, String id) {
    super(id, name);
  }

  public Restaurant(String name, String id, List<Table> tables) {
    super(id, name);
    this.tables = tables;
  }

  public List<Table> getTables() {
    return tables;
  }

  public void setTables(List<Table> tables) {
    this.tables = tables;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("id: {}, name: {}", this.getId(), this.getName()));
    sb.append(String.format("Tables: {}" + Arrays.asList(this.getTables())));
    return sb.toString();
  }

}