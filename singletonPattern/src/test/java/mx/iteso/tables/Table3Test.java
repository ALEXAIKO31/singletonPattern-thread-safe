package mx.iteso.tables;

import mx.iteso.singleton.Dish;
import mx.iteso.singleton.Drink;
import mx.iteso.singleton.TableOrder;
import mx.iteso.singleton.tables.Table3;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by ALEX on 28/10/2015.
 */
public class Table3Test {
    private TableOrder tableOrder;
    private TableOrder tableOrder1;
    private Drink drink;
    private Dish dish;

    @Before
    public void setUp(){
        tableOrder = Table3.getInstance();
        drink = mock(Drink.class);
        dish = mock(Dish.class);
        when(drink.getName()).thenReturn("");
        when(drink.getWaiter()).thenReturn("");
        when(drink.getPrice()).thenReturn(0f);
        when(dish.getName()).thenReturn("");
        when(dish.getWaiter()).thenReturn("");
        when(dish.getPrice()).thenReturn(0f);
    }


    @Test
    public void testUniqueInstance(){
        tableOrder.addDrink(drink);
        tableOrder.addDish(dish);
        tableOrder1= Table3.getInstance();
        tableOrder1.addDish(dish);
        tableOrder1.printCheck();
        verify(drink,times(1)).getName();
        verify(drink,times(2)).getPrice();
        verify(drink,times(1)).getWaiter();
        verify(dish,times(2)).getName();
        verify(dish,times(4)).getPrice();
        verify(dish,times(2)).getWaiter();
    }

    @Test
    public void testClearDrinksDishes(){
        tableOrder.addDish(dish);
        tableOrder.addDrink(drink);
        tableOrder.clearDishes();
        tableOrder.clearDrinks();
        assertEquals(tableOrder.dishes.size(),0);
        assertEquals(tableOrder.drinks.size(),0);
    }

    @Test
    public void testClearOrder(){
        tableOrder.addDrink(drink);
        tableOrder.addDish(dish);
        Table3.clearOrder();
        tableOrder= Table3.getInstance();
        tableOrder.addDrink(drink);
        tableOrder.addDrink(drink);
        tableOrder.addDrink(drink);
        tableOrder.addDish(dish);
        tableOrder.printCheck();;
        verify(drink,times(3)).getName();
        verify(drink,times(6)).getPrice();
        verify(drink,times(3)).getWaiter();
        verify(dish,times(1)).getName();
        verify(dish,times(2)).getPrice();
        verify(dish,times(1)).getWaiter();
    }
}
