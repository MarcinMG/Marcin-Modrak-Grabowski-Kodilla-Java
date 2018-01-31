package com.kodilla.sudoku;

public class SudokuRunner {

    public static void main(String[] args) {

        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            System.out.println("R - Rozwiaz kolejne Sudoku  Z - Zakoncz program");
            gameFinished = theGame.resolveSudoku();
        }

    }
}
