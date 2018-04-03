package com.kodilla.sudoku;

public class SudokuRunner {

    public static void main(String[] args) {

        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            SudokuBoard sudokuBoard = theGame.createEmptyBoard();
            sudokuBoard.makeBlocks(sudokuBoard);
            theGame.showSudokuBoard(sudokuBoard);
            theGame.fillSudoku(sudokuBoard);
            gameFinished = theGame.resolveSudoku(sudokuBoard);
            theGame.showSudokuBoard(sudokuBoard);
            System.out.println("Sudoku rozwiazane? " + gameFinished);
        }

    }
}
