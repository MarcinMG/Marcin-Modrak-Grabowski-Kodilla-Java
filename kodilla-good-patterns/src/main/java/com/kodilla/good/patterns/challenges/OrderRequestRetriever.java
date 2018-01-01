package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("Marcin", "Modrak-Grabowski");

        Product product = new Product("Kapcie");

        LocalDate productOrderDate = LocalDate.of(2018, 01, 01);

        return new OrderRequest(user, product, productOrderDate);
    }
}
