package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThickCakeDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        //When
        BigDecimal calculateCost = theOrder.getCost();
        System.out.println("Total cost: " + theOrder.getCost());
        //Then
        assertEquals(new BigDecimal(27), calculateCost);
    }
    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThickCakeDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        System.out.println(theOrder.getDescription());
        //Then
        assertEquals( "Pizza with tomato sauce and cheese + thick cake + extra cheese + salami", description);
    }
}
