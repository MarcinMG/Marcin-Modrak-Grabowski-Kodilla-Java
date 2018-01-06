package com.kodilla.good.patterns.challenges.food2Door;

import java.time.LocalDate;

public class OrderServiceMain {

    public static void main(String[] args) {

        OrderReq orderReq = new OrderReq("Marchew", 1000,
                LocalDate.of(2018, 02,15), false);

        Product product1 = new Product("Marchew", 2000,
                LocalDate.of(2018, 02, 15), false);
        Product product2 = new Product("Jabłka", 1500,
                LocalDate.of(2019, 01, 01), false);
        Product product3 = new Product("Jajka", 500,
                LocalDate.of(2018, 05, 01), true);

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        extraFoodShop.getProductExtraFoodShop().add(product1);
        HealthyShop healthyShop = new HealthyShop();
        healthyShop.getProductHealthyShop().add(product3);
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        glutenFreeShop.getProductGlutenFreeShop().add(product2);

        SuplierSelect suplierSelect = new SuplierSelect(orderReq, extraFoodShop.getProductExtraFoodShop(),
                healthyShop.getProductHealthyShop(), glutenFreeShop.getProductGlutenFreeShop());

        FinishOrder finishOrder = new FinishOrder(suplierSelect.select(), extraFoodShop, healthyShop, glutenFreeShop);
        finishOrder.finish();

    }
}
