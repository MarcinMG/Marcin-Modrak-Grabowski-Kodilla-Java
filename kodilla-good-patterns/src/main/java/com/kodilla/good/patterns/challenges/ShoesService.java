package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class ShoesService implements  OrderService{
    public boolean order(User user, Product product, LocalDate productOrderDate) {
        System.out.println("Ordered " + product.getProductName() + " for " + user.getName() + " " + user.getSurname()
        + " on dated " + productOrderDate);
        return true;
    }
}
