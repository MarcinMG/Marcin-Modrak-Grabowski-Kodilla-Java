package com.kodilla.rps;

import java.util.Scanner;

public class RpsRules {

    private String PlayerName;
    private int numberOfWins;

    public String getPlayerName() {
        return PlayerName;
    }
    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }
    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public void getInfo() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int wins;
        System.out.print("Podaj swoje imię: ");
        name = scanner.nextLine();
        do {
            System.out.print("Podaj do ilu wygranych: ");
           // wins = scanner.nextInt();
            wins = conwertuj(scanner.nextLine());
        }while (wins<1);
        setPlayerName(name);
        setNumberOfWins(wins);
    }

    public int conwertuj(String wins) {
        int wynik =0;
        try {
            wynik = Integer.parseInt(wins);
        }catch (NumberFormatException e) {
            System.out.println("wpisz poprawna liczbe");
        }
        return wynik;
    }
}
