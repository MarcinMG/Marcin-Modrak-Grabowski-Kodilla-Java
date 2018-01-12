package com.kodilla.rps;

import java.util.Scanner;

public class RpsGame {

    private RpsRules rpsRules;
    private boolean end = false;
    private int actualRound = 1;
    private int computerChoice;
    private int playerScore = 0;
    private int computerScore = 0;
    private String playerChoice;
    private String quitGame = "n";
    private String newGame = "n";
    private String computerChoiceString;

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
        newGame = "n";
    }

    public void setPlayerScore() {
        playerScore++;
        System.out.println("  *Punkt dla gracza");
    }

    public void setComputerChoice() {
        computerScore++;
        System.out.println("  *Punkt dla komputera");
    }

    @Override
    public String toString() {
        return "Podsumowanie gry: " + '\n' +
                "Rundy: " + actualRound + '\n' +
                "Wynik: " + playerScore + " : " + computerScore;
    }

    public String startNewGame() {

        String result = "quit";
        RpsRandom random = new RpsRandom();
        Scanner scanner = new Scanner(System.in);

        showRules();

        while(!end) {

            System.out.println("Runda nr: " + actualRound);
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
                    System.out.println("Czy na pewno zakończyć grę? T-tak N-nie");
                    do {
                        quitGame = scanner.next();
                    } while ((!quitGame.equals("t")) && (!(quitGame.equals("n"))));
                } else if (playerChoice.equals("n")) {
                    System.out.println("Czy na pewno zakończyć aktualną grę?? T-tak N-nie");
                    do {
                        newGame = scanner.next();
                    } while ((!newGame.equals("t")) && (!(newGame.equals("n"))));
                }

            } while (!(playerChoice.equals("KAMIEŃ")) && !(playerChoice.equals("PAPIER"))
                    && !(playerChoice.equals("NOŻYCE")) && !(quitGame.equals("t")) && !(newGame.equals("t")));

            computerChoice = random.GetRandom();
            if (computerChoice == 1) {
                computerChoiceString = "KAMIEŃ";
            } else if (computerChoice == 2) {
                computerChoiceString = "PAPIER";
            } else computerChoiceString = "NOŻYCE";

            if (!(quitGame.equals("t")) && !(newGame.equals("t"))) {
                System.out.print("Gracz: " + playerChoice + " Komputer: " + computerChoiceString);

                if (!playerChoice.equals(computerChoiceString)) {
                    if ((playerChoice.equals("KAMIEŃ")) && (computerChoiceString.equals("PAPIER"))) {
                        setComputerChoice();
                    } else if ((playerChoice.equals("KAMIEŃ")) && (computerChoiceString.equals("NOŻYCE"))) {
                        setPlayerScore();
                    } else if ((playerChoice.equals("PAPIER")) && (computerChoiceString.equals("KAMIEŃ"))) {
                        setPlayerScore();
                    } else if ((playerChoice.equals("PAPIER")) && (computerChoiceString.equals("NOŻYCE"))) {
                        setComputerChoice();
                    } else if ((playerChoice.equals("NOŻYCE")) && (computerChoiceString.equals("KAMIEŃ"))) {
                        setComputerChoice();
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
                    result = "Gracz";
                } else {
                    result = "komputer";
                }
            }else actualRound++;;

            if (quitGame.equals("t")) {
                System.exit(0);
            }

            if (newGame.equals("t")) {
                getReady();
            }
        }

        return result;
    }
}
