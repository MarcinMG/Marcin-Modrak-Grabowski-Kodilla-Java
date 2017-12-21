package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World implements PeopleQuantity{
    private final List<Continent> theWorld = new ArrayList<>();

    public List<Continent> getTheWorld() {
        return theWorld;
    }

    public void addContinent(Continent continent) {
        theWorld.add(continent);
    }

    @Override
    public BigDecimal getPeopleQuantity(){
        return theWorld.stream()
                .flatMap(c -> c.getContinentName().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
