package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    boolean resolveSudoku() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.makeBoard();
        sudokuBoard.setElementInRow(8,8,9);
        String formattedString = sudokuBoard.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        System.out.println(formattedString);

       // sudokuBoard.setElementInRow(8,8,9);
      //  System.out.println(sudokuBoard);

//        SudokuRow sudokuTestRow = new SudokuRow();
//        sudokuTestRow.makeRow();
//        sudokuTestRow.setElement(1, 2);
//        System.out.println(sudokuTestRow);

        Scanner scanner = new Scanner(System.in);
        String exitGame;
        do {
            exitGame = scanner.next();
        } while ((!exitGame.equals("r")) && (!(exitGame.equals("z"))));
        return (exitGame.equals("z"));
    }
}
