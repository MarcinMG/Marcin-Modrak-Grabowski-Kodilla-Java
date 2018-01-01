package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequest {

    public String name;
    public String surName;
    public String productName;
    public LocalDate productOrderDate;

    public OrderRequest(String name, String surName, String productName, LocalDate productOrderDate) {
        this.name = name;
        this.surName = surName;
        this.productName = productName;
        this.productOrderDate = productOrderDate;
    }

    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public String getProductName() {
        return productName;
    }
    public LocalDate getProductOrderDate() {
        return productOrderDate;
    }
}
