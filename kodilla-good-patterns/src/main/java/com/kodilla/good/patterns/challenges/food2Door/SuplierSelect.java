package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDate;
import java.util.HashSet;

public class SuplierSelect {

    OrderReq orderReq;

    public SuplierSelect(OrderReq orderReq) {
        this.orderReq = orderReq;
    }

    HashSet<Product> productExtraFoodShop = new HashSet<>();
    HashSet<Product> productHealthyShop = new HashSet<>();
    HashSet<Product> productGlutenFreeShop = new HashSet<>();

    Supplier select() {
        for (Product theProduct : productExtraFoodShop) {
            if ((theProduct.productName == orderReq.productName) && (theProduct.productQuantity >= orderReq.productQuantity)){
                return new ExtraFoodShop();
            }
        }
         for(Product theProduct : productHealthyShop) {
             if ((theProduct.productName == orderReq.productName) && (theProduct.productQuantity >= orderReq.productQuantity)){
                 return new HealthyShop();
             }
         }
         for(Product theProduct : productGlutenFreeShop) {
            if ((theProduct.productName == orderReq.productName) && (theProduct.productQuantity >= orderReq.productQuantity)){
                return new GlutenFreeShop();
            }
        }
        return new NoFoundProductInfo();
    }
}
