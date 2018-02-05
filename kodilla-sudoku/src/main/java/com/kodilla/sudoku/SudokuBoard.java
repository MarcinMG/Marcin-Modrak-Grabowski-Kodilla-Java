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
        System.out.format("╔═══════════╦══════════╦═══════════╗%n");
        System.out.format("║" + board.get(0) + " ║%n");
        System.out.format("║" + board.get(1) + " ║%n");
        System.out.format("║" + board.get(2) + " ║%n");
        System.out.format("╟═══════════╬══════════╬═══════════╢%n");
        System.out.format("║" + board.get(3) + " ║%n");
        System.out.format("║" + board.get(4) + " ║%n");
        System.out.format("║" + board.get(5) + " ║%n");
        System.out.format("╟═══════════╬══════════╬═══════════╢%n");
        System.out.format("║" + board.get(6) + " ║%n");
        System.out.format("║" + board.get(7) + " ║%n");
        System.out.format("║" + board.get(8) + " ║%n");
        System.out.format("╚═══════════╩══════════╩═══════════╝%n");
        System.out.format("+----------+--------+---------+%n");
        System.out.format("|" + board.get(0) + " |%n");
        System.out.format("|" + board.get(1) + " |%n");
        System.out.format("|" + board.get(2) + " |%n");
        System.out.format("+----------+--------+---------+%n");
        System.out.format("|" + board.get(3) + " |%n");
        System.out.format("|" + board.get(4) + " |%n");
        System.out.format("|" + board.get(5) + " |%n");
        System.out.format("+----------+--------+---------+%n");
        System.out.format("|" + board.get(6) + " |%n");
        System.out.format("|" + board.get(7) + " |%n");
        System.out.format("|" + board.get(8) + " |%n");
        System.out.format("+----------+--------+---------+%n");
        return "";
    }

    public void setBoard(ArrayList<SudokuRow> board) {
        this.board = board;
    }

    public void setElementInRow(int rowNumber, int elementNumber, int elementValue) {
        board.get(rowNumber).setElement(elementNumber, elementValue);
    }
}
