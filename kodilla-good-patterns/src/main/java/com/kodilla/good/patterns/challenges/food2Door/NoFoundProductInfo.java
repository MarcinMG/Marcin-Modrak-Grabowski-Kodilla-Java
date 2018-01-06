package com.kodilla.good.patterns.challenges.food2Door;

public class NoFoundProductInfo implements Supplier {

    public boolean process() {
        System.out.println("Nie znaleziono produktu u żadnego dostawcy");
        return false;
    }
}
