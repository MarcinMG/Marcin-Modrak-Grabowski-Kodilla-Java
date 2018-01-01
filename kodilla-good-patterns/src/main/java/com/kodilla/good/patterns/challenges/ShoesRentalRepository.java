package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class ShoesRentalRepository implements OrderRepository {
    public boolean createOrder(User user, Product product, LocalDate productDateOrder) {
        System.out.println("Saved order to database ...ok");
        return true;
    }
}
