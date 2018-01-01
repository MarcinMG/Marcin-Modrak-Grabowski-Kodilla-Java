package com.kodilla.good.patterns.challenges;

public class OrderDto {

    public String name;
    public String surName;
    public boolean isOrdered;

    public OrderDto(String name, String surName, boolean isOrdered) {
        this.name = name;
        this.surName = surName;
        this.isOrdered = isOrdered;
    }

    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public boolean isOrdered() {
        return isOrdered;
    }
}
