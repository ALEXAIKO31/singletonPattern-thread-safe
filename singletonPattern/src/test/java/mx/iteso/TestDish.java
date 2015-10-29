package mx.iteso;

import mx.iteso.singleton.Dish;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ALEX on 28/10/2015.
 */
public class TestDish {
    private Dish dish;
    @Before
    public void setUp(){
        dish = new Dish();
    }

    @Test
    public void testGetSet(){
        dish.setDescription("des");
        dish.setName("name");
        dish.setPrice(10f);
        dish.setWaiter("1");
        assertEquals(dish.getDescription(),"des");
        assertEquals(dish.getName(),"name");
        assertEquals(dish.getPrice(),10f,0);
        assertEquals(dish.getWaiter(),"1");
    }

}
