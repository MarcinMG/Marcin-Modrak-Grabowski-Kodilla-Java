package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDate;

public class OrderServiceMain {

    public static void main(String[] args) {

        OrderReq orderReq = new OrderReq("Jajka", 100,
                LocalDate.of(2018, 02,15), false);

        Product product1 = new Product("Marchew", 2000,
                LocalDate.of(2018, 02, 15), false);
        Product product2 = new Product("Jabłka", 1500,
                LocalDate.of(2019, 01, 01), false);
        Product product3 = new Product("Jajka", 500,
                LocalDate.of(2018, 05, 01), true);

        SuplierSelect suplierSelect = new SuplierSelect(orderReq);

        suplierSelect.productExtraFoodShop.add(product1);
        suplierSelect.productHealthyShop.add(product3);
        suplierSelect.productGlutenFreeShop.add(product2);

        if(suplierSelect.select().process()) {
            System.out.println("Proces zamówienia zakończono pomyślnie");
        } else {
            System.out.println("Nie złożono zamówienia");
        }

    }
}
