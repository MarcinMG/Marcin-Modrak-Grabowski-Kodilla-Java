package com.kodilla.good.patterns.challenges.aircompany;

import java.time.LocalDate;

public class Flight {

    String departureAirport;
    String arrivalAirport;
    LocalDate departureDate;

    public Flight(String departureAirport, String arrivalAirport, LocalDate departureDate) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departureAirport.equals(flight.departureAirport)) return false;
        if (!arrivalAirport.equals(flight.arrivalAirport)) return false;
        return departureDate.equals(flight.departureDate);
    }

    @Override
    public int hashCode() {
        return departureDate.hashCode();
    }

    @Override
    public String toString() {
        return
                "Z: " + departureAirport +
                " do: " + arrivalAirport +
                " dnia: " + departureDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }
    public String getArrivalAirport() {
        return arrivalAirport;
    }
    public LocalDate getDepartureTime() {
        return departureDate;
    }

}
