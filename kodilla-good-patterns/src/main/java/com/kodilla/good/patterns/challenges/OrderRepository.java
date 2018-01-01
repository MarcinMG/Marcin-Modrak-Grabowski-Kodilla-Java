package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public interface OrderRepository {
    public boolean createOrder(String name, String surName, String productName, LocalDate productDateOrder);
}
