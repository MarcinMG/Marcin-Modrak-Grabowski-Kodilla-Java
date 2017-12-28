package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    String airport1 = new String("Warsaw");
    String airport2 = new String("Berlin");
    String airport3 = new String("Bergen");

    Boolean foundDepartureAirport = false;
    Boolean foundArrivalAirport = false;


    public void findFlight(Flight flight) throws RouteNotFoundException{
        HashMap<String, Boolean> airportDatabase = new HashMap<>();

        airportDatabase.put(airport1, true);
        airportDatabase.put(airport2, true);
        airportDatabase.put(airport3, false);

        for(Map.Entry<String, Boolean> entry : airportDatabase.entrySet()) {
            if(flight.getDepartureAirport().equals(entry.getKey())) {
               foundDepartureAirport = true;
            }
        }

        for(Map.Entry<String, Boolean> entry : airportDatabase.entrySet()) {
            if(flight.getArrivalAirport().equals(entry.getKey()) && entry.getValue()) {
                foundArrivalAirport = true;
            }
        }

        if(foundDepartureAirport && foundArrivalAirport) {
            System.out.println("We can fly this route");
        }else throw new RouteNotFoundException();

    }
}
