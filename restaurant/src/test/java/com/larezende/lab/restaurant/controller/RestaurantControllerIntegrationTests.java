package com.larezende.lab.restaurant.controller;


import com.larezende.lab.restaurant.RestaurantApp;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestaurantApp.class)
public class RestaurantControllerIntegrationTests extends
    AbstractRestaurantControllerTests {

}