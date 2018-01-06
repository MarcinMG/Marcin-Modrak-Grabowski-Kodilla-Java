package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDateTime;

public class HealthyShop implements Supplier{

    public boolean process(){
        System.out.println("Produkt z zamówienia znaleziono w " + getClass().getSimpleName());
        System.out.println(LocalDateTime.now() + "  Wysłano zamówienie do producenta");
        System.out.println(LocalDateTime.now() + "  Otrzymano potwierdzenie");
        System.out.println(LocalDateTime.now() + "  Zapisano w bazie");
        return true;
    }

}
