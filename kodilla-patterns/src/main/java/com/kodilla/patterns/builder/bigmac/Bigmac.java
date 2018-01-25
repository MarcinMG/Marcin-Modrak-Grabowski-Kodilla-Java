package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Bigmac {
    private final boolean roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private boolean roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();
        private boolean ifFoundIngredient = false;

        public BigmacBuilder roll(boolean roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            Set<String> posibleSauce = new HashSet<>();
            posibleSauce.add("standard");
            posibleSauce.add("1000 wysp");
            posibleSauce.add("barbecue");
            if (!posibleSauce.contains(sauce)) {
                throw new IllegalStateException("Sos " + sauce + " nie znaleziony");
            }
            Set<String> posibleIngredients = new HashSet<>();
            posibleIngredients.add("sałata");
            posibleIngredients.add("cebula");
            posibleIngredients.add("bekon");
            posibleIngredients.add("ogórek");
            posibleIngredients.add("papryczki chilli");
            posibleIngredients.add("pieczarki");
            posibleIngredients.add("krewetki");
            posibleIngredients.add("ser");
            for(String skladnik : ingredients) {
                if(posibleIngredients.contains(skladnik)) {
                        ifFoundIngredient = true;
                    }
                if (!ifFoundIngredient) {
                    throw new IllegalStateException("Skladnik " + skladnik + " niedostepny");
                }
                ifFoundIngredient = false;
            }
            return new Bigmac(roll, burgers, sauce, ingredients);
            }
        }

    private Bigmac(boolean roll, int burgers, String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers='" + burgers + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
