package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDateTime;
import java.util.HashSet;

public class GlutenFreeShop implements Supplier{

    public boolean process(){
        System.out.println(LocalDateTime.now() + "  Wysłano zamówienie do producenta");
        System.out.println(LocalDateTime.now() + "  Otrzymano potwierdzenie");
        System.out.println(LocalDateTime.now() + "  Zapisano w bazie");
        return true;
    }

    HashSet<Product> productGlutenFreeShop = new HashSet<Product>();

    public HashSet<Product> getProductGlutenFreeShop() {
        return productGlutenFreeShop;
    }
}
