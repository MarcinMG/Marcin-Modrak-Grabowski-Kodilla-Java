package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieve(String name, String surName, String productName, LocalDate productOrderDate) {

        return new OrderRequest(name, surName, productName, productOrderDate);
    }
}
