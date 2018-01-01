package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequest {

    public User user;
    public Product product;
    public LocalDate productOrderDate;

    public OrderRequest(final User user, final Product product, final LocalDate productOrderDate) {
        this.user = user;
        this.product = product;
        this.productOrderDate = productOrderDate;
    }

    public User getUser() {
        return user;
    }
    public Product getProduct() {
        return product;
    }
    public LocalDate getProductOrderDate() {
        return productOrderDate;
    }
}
