package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class ShoesService implements  OrderService{
    public boolean order(String name, String surName, String productName, LocalDate productOrderDate) {
        System.out.println("Ordered " + productName + " for " + name + " " + surName
        + " on dated " + productOrderDate);
        return true;
    }
}
