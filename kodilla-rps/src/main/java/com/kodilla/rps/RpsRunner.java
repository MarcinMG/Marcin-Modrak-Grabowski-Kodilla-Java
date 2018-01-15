package com.kodilla.rps;

public class RpsRunner {

    static int licznik=0;

    public static void main(String[] args) {

        Boolean result;
        RpsRules rules = new RpsRules();

        wyswietl();
        dodaj(1,2,licznik);
        dodaj(3,4,licznik);
        wyswietl();
        System.out.println(licznik);

        do {
            rules.getInfo();
            RpsGame game = new RpsGame(rules);
            game.startNewGame();
            System.out.println(game);
            System.out.println("x-koniec gry  n-nowa gra");
            result = game.exitMenu();
        }while (!result);

    }

    public static void wyswietl() {
        licznik++;
        System.out.println("tekst");
    }

    public static void dodaj(int a, int b, int counter) {
        licznik+=counter;
        System.out.println(a+b);
    }
}
