package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        RpsRules rules = new RpsRules();


        while(!end) {
            rules.setPlayerName("Marcin");
            rules.setNumberOfRounds(2);
            System.out.println("Your name: " + rules.getPlayerName());
            System.out.println("Number of rounds: " + rules.getNumberOfRounds());
            end = true;
        }
    }
}
