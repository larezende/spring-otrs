package restaurant.service;

import libs.entity.Entity;
import restaurant.entity.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


public interface RestaurantService {

    public void add(Restaurant restaurant) throws Exception;

    public void update(Restaurant restaurant) throws Exception;

    public void delete(String id) throws Exception;

    public Entity findById(String restaurantId) throws Exception;

    public Collection<Restaurant> findByName(String name) throws Exception;

    public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}