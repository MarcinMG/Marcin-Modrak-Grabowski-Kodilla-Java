package com.kodilla.rps;

import java.util.Scanner;

public class RpsRules {
    private String PlayerName;
    private int numberOfRounds;

    public String getPlayerName() {
        return PlayerName;
    }
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }
    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void getInfo() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int rounds;
        System.out.print("Podaj swoje imię: ");
        name = scanner.nextLine();
        System.out.print("Podaj ilość rund: ");
        rounds = scanner.nextInt();
        setPlayerName(name);
        setNumberOfRounds(rounds);
    }

    public void showRules() {
        System.out.println("Klawisz 1 - zagranie \"kamień\"");
        System.out.println("Klawisz 2 - zagranie \"papier\"");
        System.out.println("Klawisz 3 - zagranie \"nożyce\"");
        System.out.println("Klawisz x - wyjdź z gry");
        System.out.println("Klawisz n - zagraj od nowa");
    }
}
