package restaurant.controller;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import restaurant.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RestaurantControllerIntegrationTests extends
        AbstractRestaurantControllerTests {

}