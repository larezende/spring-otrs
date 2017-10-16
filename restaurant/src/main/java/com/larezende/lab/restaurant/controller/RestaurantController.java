package com.larezende.lab.restaurant.controller;

import com.larezende.lab.libs.entity.Entity;
import com.larezende.lab.restaurant.entity.Restaurant;
import com.larezende.lab.restaurant.service.RestaurantService;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

  protected Logger logger = Logger.getLogger(RestaurantController.class.getName());

  protected RestaurantService restaurantService;

  @Autowired
  public RestaurantController(RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  /**
   * Fetch restaurants with the specified name. A partial case-insensitive match is supported. So
   * <code>http://.../restaurants/rest</code> will find any restaurants with upper or lower case
   * 'rest' in their name.
   *
   * @return A non-null, non-empty collection of restaurants.
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {

    logger.info(String.format(
        "com.larezende.lab.libs-com.larezende.lab.libs.service findByName() invoked:{} for {} ",
        restaurantService.getClass().getName(), name));
    name = name.trim().toLowerCase();
    Collection<Restaurant> restaurants;
    try {
      restaurants = restaurantService.findByName(name);
    } catch (Exception ex) {
      logger.log(Level.WARNING, "Exception raised findByName REST Call", ex);
      return new ResponseEntity<Collection<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return restaurants.size() > 0 ? new ResponseEntity<Collection<Restaurant>>(restaurants,
        HttpStatus.OK)
        : new ResponseEntity<Collection<Restaurant>>(HttpStatus.NO_CONTENT);
  }

  /**
   * Fetch restaurants with the given id. <code>http://.../v1/restaurants/{restaurant_id}</code>
   * will return com.larezende.lab.libs with given id.
   *
   * @return A non-null, non-empty collection of restaurants.
   */
  @RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
  public ResponseEntity<Entity> findById(@PathVariable("restaurant_id") String id) {

    logger.info(String.format(
        "com.larezende.lab.libs-com.larezende.lab.libs.service findById() invoked:{} for {} ",
        restaurantService.getClass().getName(), id));
    id = id.trim();
    Entity restaurant;
    try {
      restaurant = restaurantService.findById(id);
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Exception raised findById REST Call", ex);
      return new ResponseEntity<Entity>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return restaurant != null ? new ResponseEntity<Entity>(restaurant, HttpStatus.OK)
        : new ResponseEntity<Entity>(HttpStatus.NO_CONTENT);
  }

  /**
   * Add com.larezende.lab.libs with the specified information.
   *
   * @return A non-null com.larezende.lab.libs.
   * @throws RestaurantNotFoundException If there are no matches at all.
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurantVO) {

    logger.info(String
        .format("com.larezende.lab.libs-com.larezende.lab.libs.service add() invoked: %s for %s",
            restaurantService.getClass().getName(), restaurantVO.getName()));

    Restaurant restaurant = new Restaurant(null, null, null);
    BeanUtils.copyProperties(restaurantVO, restaurant);
    try {
      restaurantService.add(restaurant);
    } catch (Exception ex) {
      logger.log(Level.WARNING, "Exception raised add Restaurant REST Call " + ex);
      return new ResponseEntity<Restaurant>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    return new ResponseEntity<Restaurant>(HttpStatus.CREATED);
  }
}