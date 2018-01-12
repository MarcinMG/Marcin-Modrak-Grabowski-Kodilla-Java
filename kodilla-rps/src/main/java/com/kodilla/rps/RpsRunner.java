package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {

        String result;
        Scanner scanner = new Scanner(System.in);

        RpsRules rules = new RpsRules();

        do {
            rules.getInfo();
            RpsGame game = new RpsGame(rules);
            result = game.startNewGame();
            System.out.println(game);
            System.out.println("Wygrał: " + result);
            System.out.println("x-koniec gry  n-nowa gra");
            do {
                result = scanner.next();
            } while ((!result.equals("x")) && (!(result.equals("n"))));

        }while (!result.equals("x"));

    }
}
