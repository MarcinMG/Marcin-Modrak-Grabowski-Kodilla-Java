package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public PizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(35));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by Taxi Network";
    }
}
