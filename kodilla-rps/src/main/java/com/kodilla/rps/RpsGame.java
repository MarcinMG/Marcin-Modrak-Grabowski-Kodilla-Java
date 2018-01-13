package com.kodilla.rps;

import java.util.Scanner;

public class RpsGame {

    private RpsRules rpsRules;
    private boolean end = false;
    private boolean newGame = false;
    private int actualRound = 1;
    private int playerScore = 0;
    private int computerScore = 0;
    private String winner = "brak";
    private String playerChoice;

    public RpsGame(RpsRules rpsRules) {
        this.rpsRules = rpsRules;
    }

    public void showRules() {
        System.out.println("1 - zagranie \"KAMIEŃ\"");
        System.out.println("2 - zagranie \"PAPIER\"");
        System.out.println("3 - zagranie \"NOŻYCE\"");
        System.out.println("x - wyjdź z gry");
        System.out.println("n - zagraj od nowa" + '\n');
    }

    public void getReady() {
        rpsRules.getInfo();
        showRules();
        actualRound = 1;
        playerScore = 0;
        computerScore = 0;
        newGame = false;
        winner = "brak";
    }

    public void setPlayerScore() {
        playerScore++;
        System.out.println("  *Punkt dla gracza");
    }

    public void setComputerScore() {
        computerScore++;
        System.out.println("  *Punkt dla komputera");
    }

    @Override
    public String toString() {
        return "Podsumowanie gry: " + '\n' +
                "Rundy: " + actualRound + '\n' +
                "Wynik: " + playerScore + " : " + computerScore + '\n' +
                "Wygrał: " + winner;
    }

    public boolean endGame() {
        String quitGame;
        System.out.println("Czy na pewno zakończyć grę? T-tak N-nie");
        Scanner scanner = new Scanner(System.in);
        do {
            quitGame = scanner.next();
        } while ((!quitGame.equals("t")) && (!(quitGame.equals("n"))));
        return (quitGame.equals("t"));
    }

    public boolean exitMenu() {
        String exitGame;
        Scanner scanner = new Scanner(System.in);
        do {
            exitGame = scanner.next();
        } while ((!exitGame.equals("x")) && (!(exitGame.equals("n"))));
        return (exitGame.equals("x"));
    }

    public void yourMove() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(rpsRules.getPlayerName() + ", Twój ruch: ");
            playerChoice = scanner.next();
            if (playerChoice.equals("1")) {
                playerChoice = "KAMIEŃ";
            } else if (playerChoice.equals("2")) {
                playerChoice = "PAPIER";
            } else if (playerChoice.equals("3")) {
                playerChoice = "NOŻYCE";
            } else if (playerChoice.equals("x")) {
                end = endGame();
            } else if (playerChoice.equals("n")) {
                newGame = endGame();
            }

        } while (!(playerChoice.equals("KAMIEŃ")) && !(playerChoice.equals("PAPIER"))
                && !(playerChoice.equals("NOŻYCE")) && !end && !newGame);
    }

    public void startNewGame() {

        int computerChoice;
        String computerChoiceString;
        RpsRandom random = new RpsRandom();
        showRules();

        while(!end) {

            System.out.println("Runda nr: " + actualRound);
            yourMove();

            computerChoice = random.GetRandom();
            if (computerChoice == 1) {
                computerChoiceString = "KAMIEŃ";
            } else if (computerChoice == 2) {
                computerChoiceString = "PAPIER";
            } else computerChoiceString = "NOŻYCE";

            if (!end && !newGame) {
                System.out.print("Gracz: " + playerChoice + " Komputer: " + computerChoiceString);

                if (!playerChoice.equals(computerChoiceString)) {
                    if ((playerChoice.equals("KAMIEŃ")) && (computerChoiceString.equals("PAPIER"))) {
                        setComputerScore();
                    } else if ((playerChoice.equals("KAMIEŃ")) && (computerChoiceString.equals("NOŻYCE"))) {
                        setPlayerScore();
                    } else if ((playerChoice.equals("PAPIER")) && (computerChoiceString.equals("KAMIEŃ"))) {
                        setPlayerScore();
                    } else if ((playerChoice.equals("PAPIER")) && (computerChoiceString.equals("NOŻYCE"))) {
                        setComputerScore();
                    } else if ((playerChoice.equals("NOŻYCE")) && (computerChoiceString.equals("KAMIEŃ"))) {
                        setComputerScore();
                    } else {
                        setPlayerScore();
                    }
                } else {
                    System.out.println(" REMIS");
                }
                System.out.println("Gracz: " + playerScore + " Komputer: " + computerScore + '\n');
            }

            if ((playerScore == rpsRules.getNumberOfWins()) || (computerScore == rpsRules.getNumberOfWins())) {
                end = true;
                if (playerScore > computerScore) {
                    winner = "Gracz";
                }else {
                    winner = "Komputer";
                }
            }else actualRound++;

            if (newGame) {
                getReady();
            }
        }
    }
}
