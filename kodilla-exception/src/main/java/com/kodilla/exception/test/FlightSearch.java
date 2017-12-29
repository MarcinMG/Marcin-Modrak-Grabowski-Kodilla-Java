package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    String airport1 = new String("Warsaw");
    String airport2 = new String("Berlin");
    String airport3 = new String("Bergen");
    String airport4 = new String("Barcelona");
    String airport5 = new String("Moscow");
    String airport6 = new String("Paris");

    Flight flight1 = new Flight("Warsaw", "Paris");
    Flight flight2 = new Flight("Warsaw", "Berlin");
    Flight flight3 = new Flight("Warsaw", "Bergen");
    Flight flight4 = new Flight("Warsaw", "Moscow");
    Flight flight5 = new Flight("Berlin", "Barcelona");
    Flight flight6 = new Flight("Berlin", "Moscow");
    Flight flight7 = new Flight("Bergen", "Warsaw");
    Flight flight8 = new Flight("Moscow", "Bergen");

    public void findFlight(Flight flight) throws RouteNotFoundException{
        HashMap<String, Boolean> airportDatabase = new HashMap<>();
        airportDatabase.put(airport1, true);
        airportDatabase.put(airport2, true);
        airportDatabase.put(airport3, false);
        airportDatabase.put(airport4, true);
        airportDatabase.put(airport5, true);
        airportDatabase.put(airport6, false);

        HashMap<String, Flight> flights = new HashMap<>();
        flights.put("001", flight1);
        flights.put("002", flight2);
        flights.put("003", flight3);
        flights.put("004", flight4);
        flights.put("005", flight5);
        flights.put("006", flight6);
        flights.put("007", flight7);
        flights.put("008", flight8);

        Boolean foundDepartureAirport = false;
        Boolean foundArrivalAirport = false;
        Boolean foundDirectFlight = false;
        Boolean foundChangeFlight = false;

        //czy istnieją czynne lotniska
        for(Map.Entry<String, Boolean> entry : airportDatabase.entrySet()) {
            if(flight.getDepartureAirport().equals(entry.getKey()) && entry.getValue()) {
               foundDepartureAirport = true;
            }
        }
        for(Map.Entry<String, Boolean> entry : airportDatabase.entrySet()) {
            if(flight.getArrivalAirport().equals(entry.getKey()) && entry.getValue()) {
                foundArrivalAirport = true;
            }
        }

        if(foundDepartureAirport && foundArrivalAirport) {
            //czy istnieje lot bezposreddni
            for(Map.Entry<String, Flight> entry : flights.entrySet()) {
                if(flight.getDepartureAirport().equals(entry.getValue().getDepartureAirport())
                        && flight.getArrivalAirport().equals(entry.getValue().getArrivalAirport())) {
                    foundDirectFlight = true;
                    System.out.println("*Found route direct -> From: " + flight.getDepartureAirport() + " To: "
                            + flight.getArrivalAirport() + " NR " + entry.getKey());
                }
            }
            if(!foundDirectFlight) {
                //czy istnieje lot posredni
                System.out.println("No direct route");
                for(Map.Entry<String, Flight> entry : flights.entrySet()) {
                    if (flight.getDepartureAirport().equals(entry.getValue().getDepartureAirport())) {
                        for (Map.Entry<String, Flight> entry2 : flights.entrySet()) {
                            if (entry.getValue().getArrivalAirport().equals(entry2.getValue().getDepartureAirport())
                                    && flight.getArrivalAirport().equals(entry2.getValue().getArrivalAirport())) {
                                foundChangeFlight = true;
                                System.out.println("*Found route change -> From: " + flight.getDepartureAirport() + " To: "
                                        + entry.getValue().getArrivalAirport() + " NR " + entry.getKey() + " -> " +
                                         "From: " + entry2.getValue().getDepartureAirport() + " To: " +
                                        flight.getArrivalAirport() + " NR " + entry2.getKey());
                            }
                        }
                    }
                }
            } if (!foundChangeFlight) System.out.println("No route change");

        }else throw new RouteNotFoundException();

    }
}
