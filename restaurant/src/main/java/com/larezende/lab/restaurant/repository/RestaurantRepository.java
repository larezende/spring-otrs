package com.larezende.lab.restaurant.repository;

import com.larezende.lab.libs.repository.Repository;
import java.util.Collection;

public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {

  boolean containsName(String name);

  Collection<Restaurant> findByName(String name) throws Exception;

}
