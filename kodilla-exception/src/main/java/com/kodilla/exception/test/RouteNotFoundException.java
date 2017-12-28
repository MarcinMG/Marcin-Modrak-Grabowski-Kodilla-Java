package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception{

    public static void main(String args[]) {

        Flight flight1 = new Flight("Warsaw", "Paris");
        Flight flight2 = new Flight("Warsaw", "Berlin");
        Flight flight3 = new Flight("Warsaw", "Bergen");
        Flight flight4 = new Flight("Warsaw", "Warsaw");

        System.out.print("flight1 : "); tryCatchFinally(flight1);
        System.out.print("flight2 : "); tryCatchFinally(flight2);
        System.out.print("flight3 : "); tryCatchFinally(flight3);
        System.out.print("flight4 : "); tryCatchFinally(flight4);

    }

    public static void tryCatchFinally (Flight flight){

        FlightSearch flightSearch = new FlightSearch();

        try{
            if(flight.getDepartureAirport() != flight.getArrivalAirport()) {
                flightSearch.findFlight(flight);
            }else {
                System.out.println("Departure and arrival is the same");
            }
        }catch (com.kodilla.exception.test.RouteNotFoundException e) {
            System.out.println("Airport not found or Airport closed");
        }finally {
            System.out.print("");
        }
    }
}
