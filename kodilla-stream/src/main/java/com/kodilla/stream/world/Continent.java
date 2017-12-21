package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final List<Country> countryList = new ArrayList<>();

    public List<Country> getContinentName() {
        return countryList;
    }

    public void addCountry(Country country){
        countryList.add(country);
    }
}
