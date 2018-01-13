package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {

        Boolean result;
        RpsRules rules = new RpsRules();

        do {
            rules.getInfo();
            RpsGame game = new RpsGame(rules);
            game.startNewGame();
            System.out.println(game);
            System.out.println("x-koniec gry  n-nowa gra");
            result = game.exitMenu();
        }while (!result);

    }
}
