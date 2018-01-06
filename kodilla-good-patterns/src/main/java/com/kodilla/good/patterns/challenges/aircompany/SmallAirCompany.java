package com.kodilla.good.patterns.challenges.aircompany;

import java.util.Scanner;

public class SmallAirCompany {

    public static void main(String args[]) {

        System.out.println("SMALL AIR COMPANY");

        Scanner scanner = new Scanner(System.in);
        String departureAirport;
        String arrivalAirport;
        String choice;

        System.out.println("Wybierz opcję:");
        System.out.println("1. Rozkład lotów z danego miasta");
        System.out.println("2. Rozkład lotów do danego miasta");
        System.out.println("3. Znajdź lot z przesiadką");
        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Podaj miasto z którego chcesz lecieć: ");
                arrivalAirport = scanner.nextLine();
                FlightSearch flightSearch1 = new FlightSearch();
                flightSearch1.findFlight(arrivalAirport, "", "1");
                break;
            case "2":
                System.out.println("Podaj miasto do którego chcesz lecieć: ");
                departureAirport = scanner.nextLine();
                FlightSearch flightSearch2 = new FlightSearch();
                flightSearch2.findFlight("", departureAirport, "2");
                break;
            case "3":
                System.out.println("Podaj miasto z którego chcesz lecieć: ");
                departureAirport = scanner.nextLine();
                System.out.println("Podaj miasto do którego chcesz lecieć: ");
                arrivalAirport = scanner.nextLine();
                FlightSearch flightSearch3 = new FlightSearch();
                flightSearch3.findFlight(arrivalAirport, departureAirport, "3");
                break;
        }
    }
}
