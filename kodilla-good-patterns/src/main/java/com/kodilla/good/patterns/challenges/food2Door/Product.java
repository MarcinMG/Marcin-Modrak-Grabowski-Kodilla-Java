package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDate;

public class Product {

    String productName;
    int productQuantity;
    LocalDate productExpirationDate;
    boolean productContainGluten;

    public Product(String productName, int productQuantity, LocalDate productExpirationDate, boolean productContainGluten) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productExpirationDate = productExpirationDate;
        this.productContainGluten = productContainGluten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productQuantity != product.productQuantity) return false;
        if (productContainGluten != product.productContainGluten) return false;
        if (!productName.equals(product.productName)) return false;
        return productExpirationDate != null ? productExpirationDate.equals(product.productExpirationDate) : product.productExpirationDate == null;
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + productQuantity;
        result = 31 * result + (productExpirationDate != null ? productExpirationDate.hashCode() : 0);
        result = 31 * result + (productContainGluten ? 1 : 0);
        return result;
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
