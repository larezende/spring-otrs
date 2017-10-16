package com.larezende.lab.restaurant.controller;


import com.larezende.lab.libs.entity.Entity;
import com.larezende.lab.restaurant.entity.Restaurant;
import java.util.Collection;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractRestaurantControllerTests {

  protected static final String RESTAURANT = "1";
  protected static final String RESTAURANT_NAME = "Big-O Restaurant";

  @Autowired
  RestaurantController restaurantController;

  @Test
  public void validResturantById() {
    Logger.getGlobal().info("Start validResturantById test");
    ResponseEntity<Entity> restaurant = restaurantController.findById(RESTAURANT);

    Assert.assertEquals(HttpStatus.OK, restaurant.getStatusCode());
    Assert.assertTrue(restaurant.hasBody());
    Assert.assertNotNull(restaurant.getBody());
    Assert.assertEquals(RESTAURANT, restaurant.getBody().getId());
    Assert.assertEquals(RESTAURANT_NAME, restaurant.getBody().getName());
    Logger.getGlobal().info("End validResturantById test");
  }

  @Test
  public void validResturantByName() {
    Logger.getGlobal().info("Start validResturantByName test");
    ResponseEntity<Collection<Restaurant>> restaurants = restaurantController
        .findByName(RESTAURANT_NAME);
    Logger.getGlobal().info("In validAccount test");

    Assert.assertEquals(HttpStatus.OK, restaurants.getStatusCode());
    Assert.assertTrue(restaurants.hasBody());
    Assert.assertNotNull(restaurants.getBody());
    Assert.assertFalse(restaurants.getBody().isEmpty());
    Restaurant restaurant = (Restaurant) restaurants.getBody().toArray()[0];
    Assert.assertEquals(RESTAURANT, restaurant.getId());
    Assert.assertEquals(RESTAURANT_NAME, restaurant.getName());
    Logger.getGlobal().info("End validResturantByName test");
  }

  @Test
  public void validAdd() {
    Logger.getGlobal().info("Start validAdd test");
    Restaurant restaurant = new Restaurant("Test Restaurant", "999");

    ResponseEntity<Restaurant> restaurants = restaurantController.add(restaurant);
    Assert.assertEquals(HttpStatus.CREATED, restaurants.getStatusCode());
    Logger.getGlobal().info("End validAdd test");
  }
}