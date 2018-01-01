package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class ShoesOrderRepository implements OrderRepository {
    public boolean createOrder(String name, String surName, String productName, LocalDate productDateOrder) {
        System.out.println("Saved order to database ...ok");
        return true;
    }
}
