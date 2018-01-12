package com.kodilla.good.patterns.challenges.aircompany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.Collectors;

public class FlightSearch {

    String airport1 = "Warszawa";
    String airport2 = "Gdańsk";
    String airport3 = "Wrocław";

    Flight flight1 = new Flight("Warszawa", "Gdańsk",
            LocalDate.of(2018, 03, 01));
    Flight flight2 = new Flight("Warszawa", "Wrocław",
            LocalDate.of(2018, 03,02));
    Flight flight3 = new Flight("Gdańsk", "Warszawa",
            LocalDate.of(2018, 03, 03));
    Flight flight4 = new Flight("Gdańsk", "Wrocław",
            LocalDate.of(2018, 03, 04));
    Flight flight5 = new Flight("Wrocław", "Warszawa",
            LocalDate.of(2018, 03, 04));
    Flight flight6 = new Flight("Wrocław", "Gdańsk",
            LocalDate.of(2018, 03, 05));

    public void findFlight(String arrivalAirport, String departureAirport, String choice) {

        final HashSet<String> airportDatabase = new HashSet<>();
        airportDatabase.add("Warszawa");
        airportDatabase.add("Gdańsk");
        airportDatabase.add("Wrocław");

        final HashSet<Flight> flights = new HashSet<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);

        Boolean foundDepartureAirport = false;
        Boolean foundArrivalAirport = false;
        Boolean foundDirectFlight = false;
        Boolean foundChangeFlight = false;

        String foundArrival = airportDatabase.stream()
                .filter(s -> s.equals(arrivalAirport))
                .collect(Collectors.joining());

        String foundDeparture = airportDatabase.stream()
                .filter(s -> s.equals(departureAirport))
                .collect(Collectors.joining());

        if(choice.equals("1")) {

            if(arrivalAirport.equals(foundArrival)) {
                HashSet<Flight> theResultFlights = flights.stream()
                        .filter(f -> f.getArrivalAirport().equals(arrivalAirport))
                        .collect(Collectors.toCollection(HashSet::new));

                System.out.println("# ilość znalezionych lotów: " + theResultFlights.size());
                theResultFlights.stream()
                        .map(s -> "Z: " + s.arrivalAirport + " do: " + s.departureAirport + " dnia: " + s.departureDate)
                        .forEach(System.out::println);
            }else System.out.println("Nie znaleziono miasta");
        }

        if(choice.equals("2")) {

            if(departureAirport.equals(foundDeparture)) {
                HashSet<Flight> theResultFlights = flights.stream()
                        .filter(f -> f.getDepartureAirport().equals(departureAirport))
                        .collect(Collectors.toCollection(HashSet::new));

                System.out.println("# ilość znalezionych lotów: " + theResultFlights.size());
                theResultFlights.stream()
                        .map(s -> "Z: " + s.arrivalAirport + " do: " + s.departureAirport + " dnia: " + s.departureDate)
                        .forEach(System.out::println);
            }else System.out.println("Nie znaleziono miasta");
        }

        if(choice.equals("3")) {

            if ( (departureAirport.equals(foundDeparture)) && (arrivalAirport.equals(foundArrival))
                    && !(departureAirport.equals(arrivalAirport)) ) {
                HashSet<Flight> theResultDepartures = flights.stream()
                        .filter(f -> f.getDepartureAirport().equals(departureAirport))
                        .collect(Collectors.toCollection(HashSet::new));

                HashSet<Flight> theResultArrivals = flights.stream()
                        .filter(f -> f.getArrivalAirport().equals(arrivalAirport))
                        .collect(Collectors.toCollection(HashSet::new));

                HashSet<Flight> theResultChange =  theResultDepartures.stream()
                        .filter(r -> {
                            theResultArrivals.stream()
                                    .filter(s -> r.arrivalAirport.equals(s.departureAirport))
                                    .forEach(s -> System.out.println(r + " przesiadka " + s));
                            return true;
                        })
                        .collect(Collectors.toCollection(HashSet::new));

                System.out.println("# ilość znalezionych połączen: " + theResultChange.size()/2);
            }else System.out.println("Nie znaleziono miasta lub miasta są takie same");
        }
    }
}
