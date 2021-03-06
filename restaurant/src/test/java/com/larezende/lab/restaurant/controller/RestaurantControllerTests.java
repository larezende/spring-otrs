package com.larezende.lab.restaurant.controller;

import com.larezende.lab.libs.entity.Entity;
import com.larezende.lab.restaurant.entity.Restaurant;
import com.larezende.lab.restaurant.repository.RestaurantRepository;
import com.larezende.lab.restaurant.service.RestaurantService;
import com.larezende.lab.restaurant.service.RestaurantServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;

public class RestaurantControllerTests extends AbstractRestaurantControllerTests {

  protected static final Restaurant restaurantStaticInstance = new Restaurant(RESTAURANT,
      RESTAURANT_NAME, null);
  protected TestRestaurantRepository testRestaurantRepository = new TestRestaurantRepository();
  protected RestaurantService restaurantService = new RestaurantServiceImpl(
      testRestaurantRepository);

  @Before
  public void setup() {
    restaurantController = new RestaurantController(restaurantService);

  }

  protected static class TestRestaurantRepository implements
      RestaurantRepository<Restaurant, String> {

    private Map<String, Restaurant> entities;

    public TestRestaurantRepository() {
      entities = new HashMap();
      Restaurant restaurant = new Restaurant("Big-O Restaurant", "1", null);
      entities.put("1", restaurant);
      restaurant = new Restaurant("O Restaurant", "2", null);
      entities.put("2", restaurant);
    }

    @Override
    public boolean containsName(String name) {
      try {
        return this.findByName(name).size() > 0;
      } catch (Exception ex) {
        //Exception Handler
      }
      return false;
    }

    @Override
    public void add(Restaurant entity) {
      entities.put(entity.getId(), entity);
    }

    @Override
    public void remove(String id) {
      if (entities.containsKey(id)) {
        entities.remove(id);
      }
    }

    @Override
    public void update(Restaurant entity) {
      if (entities.containsKey(entity.getId())) {
        entities.put(entity.getId(), entity);
      }
    }

    @Override
    public Collection<Restaurant> findByName(String name) throws Exception {
      Collection<Restaurant> restaurants = new ArrayList();
      int noOfChars = name.length();
      entities.forEach((k, v) -> {
        if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
          restaurants.add(v);
        }
      });
      return restaurants;
    }

    @Override
    public boolean contains(String id) {
      throw new UnsupportedOperationException(
          "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity get(String id) {
      return entities.get(id);
    }

    @Override
    public Collection<Restaurant> getAll() {
      return entities.values();
    }
  }
}