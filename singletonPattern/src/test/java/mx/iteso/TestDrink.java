package mx.iteso;

import mx.iteso.singleton.Drink;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ALEX on 28/10/2015.
 */
public class TestDrink {
    private Drink drink;
    @Before
    public void setUp(){
        drink = new Drink();
    }

    @Test
    public void testGetSet(){
        drink.setDescription("des");
        drink.setName("name");
        drink.setPrice(10f);
        drink.setWaiter("1");
        assertEquals(drink.getDescription(),"des");
        assertEquals(drink.getName(),"name");
        assertEquals(drink.getPrice(),10f,0);
        assertEquals(drink.getWaiter(),"1");
    }
}
