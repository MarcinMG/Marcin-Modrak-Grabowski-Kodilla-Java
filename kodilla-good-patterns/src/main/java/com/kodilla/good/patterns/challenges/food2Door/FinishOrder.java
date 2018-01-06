package com.kodilla.good.patterns.challenges.food2Door;

public class FinishOrder {

    String supplier;
    Supplier extraFoodShop, healthyShop, glutenFreeShop;


    public FinishOrder(String supplier, Supplier extraFoodShop, Supplier healthyShop, Supplier glutenFreeShop) {
        this.supplier = supplier;
        this.extraFoodShop = extraFoodShop;
        this.healthyShop = healthyShop;
        this.glutenFreeShop = glutenFreeShop;
    }

    void finish() {
        if (supplier != "not found") {
            System.out.println("Produkt z zamówienia jest dostępny w " + supplier);
        } else {
            System.out.println("Produkt z zamówienia niedostępny");
        }

        if (supplier == "ExtraFoodShop") {
            if (extraFoodShop.process()) {
                System.out.println("Zamówienie złożone pomyślnie");
            }
        } else if (supplier == "HealthyFoodShop") {
            if (healthyShop.process()) {
                System.out.println("Zamówienie złożone pomyślnie");
            }
        } else if (supplier == "GlutenFreeShop") {
            if (glutenFreeShop.process()) {
                System.out.println("Zamówienie złożone pomyślnie");
            }
        }
    }
}
