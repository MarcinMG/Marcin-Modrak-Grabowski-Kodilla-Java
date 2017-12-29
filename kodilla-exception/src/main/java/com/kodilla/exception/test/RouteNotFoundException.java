package com.kodilla.exception.test;

import java.util.Scanner;

public class RouteNotFoundException extends Exception{

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String departureAirport, arrivalAirport;

        System.out.print("Podaj miasto wylotu: ");
        departureAirport = scanner.nextLine();

        System.out.print("Podaj miasto przylotu: ");
        arrivalAirport = scanner.nextLine();

        Flight flight = new Flight(departureAirport, arrivalAirport);

        tryCatchFinally(flight);

    }

    public static void tryCatchFinally (Flight flight){

        FlightSearch flightSearch = new FlightSearch();

        try{
            if( !flight.getDepartureAirport().equals(flight.getArrivalAirport()) ) {
                flightSearch.findFlight(flight);
            }else {
                System.out.println("Departure and arrival is the same");
            }
        }catch (com.kodilla.exception.test.RouteNotFoundException e) {
            System.out.println("Airport not found or Airport closed");
        }
    }
}
