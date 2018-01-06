package com.kodilla.good.patterns.challenges.food2Door;

import java.util.HashSet;

public class SuplierSelect {

    OrderReq orderReq;
    HashSet<Product> productExtraFoodShop, productHealthyShop, productGlutenFreeShop;

    public SuplierSelect(OrderReq orderReq, HashSet<Product> productExtraFoodShop, HashSet<Product> productHealthyShop,
                         HashSet<Product> productGlutenFreeShop) {
        this.orderReq = orderReq;
        this.productExtraFoodShop = productExtraFoodShop;
        this.productHealthyShop = productHealthyShop;
        this.productGlutenFreeShop = productGlutenFreeShop;
    }

    String select() {
        for (Product theProduct : productExtraFoodShop) {
            if ((theProduct.productName == orderReq.productName) && (theProduct.productQuantity >= orderReq.productQuantity)){
                return "ExtraFoodShop";
            }
        }
         for(Product theProduct : productHealthyShop) {
             if ((theProduct.productName == orderReq.productName) && (theProduct.productQuantity >= orderReq.productQuantity)){
                 return "HealthyShop";
             }
         }
         for(Product theProduct : productGlutenFreeShop) {
            if ((theProduct.productName == orderReq.productName) && (theProduct.productQuantity >= orderReq.productQuantity)){
                return "GlutenFreeShop";
            }
        }
        return "not found";
    }
}
