package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuBoard {

    ArrayList<SudokuRow> board = new ArrayList<>();

    public void makeBoard() {
        for(int n = 0; n < 9; n++) {
            board.add(new SudokuRow());
            board.get(n).makeRow();
        }
    }

    public void showRow(int number) {
        System.out.println(board.get(number));
    }

    @Override
    public String toString() {
        return "SudokuBoard{" +
                "board=" + board +
                '}';
    }

    public void setBoard(ArrayList<SudokuRow> board) {
        this.board = board;
    }

    public void setElementInRow(int rowNumber, int elementNumber, int elementValue) {
        board.get(rowNumber).setElement(elementNumber, elementValue);
    }
}
