package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDate;

public class OrderReq {

    public String productName;
    public int productQuantity;
    public LocalDate productExpirationDate;
    public boolean productContainGluten;

    public OrderReq(String productName, int productQuantity, LocalDate productExpirationDate, boolean productContainGluten) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productExpirationDate = productExpirationDate;
        this.productContainGluten = productContainGluten;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public LocalDate getProductExpirationDate() {
        return productExpirationDate;
    }

    public boolean isProductContainGluten() {
        return productContainGluten;
    }
}
