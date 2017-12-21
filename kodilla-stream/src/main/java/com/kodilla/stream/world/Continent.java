package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final List<Country> continentName = new ArrayList<>();

    public List<Country> getContinentName() {
        return continentName;
    }

    public void addCountry(Country country){
        continentName.add(country);
    }
}
