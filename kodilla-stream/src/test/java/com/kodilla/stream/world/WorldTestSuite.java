package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        //Create
        Continent europa = new Continent();
        Continent asia = new Continent();
        europa.addCountry(new Country("Polska", new BigDecimal("39000000")) );
        europa.addCountry(new Country("Francja", new BigDecimal("79000000")) );
        asia.addCountry(new Country("Japonia", new BigDecimal("89000000")) );
        asia.addCountry(new Country("Korea", new BigDecimal("69000000")) );
        World world = new World();
        world.addContinent(europa);
        world.addContinent(asia);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("276000000");
        Assert.assertEquals(expectedPeople, totalPeople);
    }
}
