package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public interface OrderService {
    public boolean order(String name, String surName, String productName, LocalDate productOrderDate);
}
