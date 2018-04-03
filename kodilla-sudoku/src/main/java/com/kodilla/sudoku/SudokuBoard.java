package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuBoard {

    ArrayList<SudokuRow> board = new ArrayList<>();
    ArrayList<SudokuBlock> blocks = new ArrayList<>();

    public void makeBoard() {
        for(int n = 0; n < 9; n++) {
            board.add(new SudokuRow());
            board.get(n).makeRow();
        }
    }

    public void makeBlocks(SudokuBoard sudokuBoard) {
        for (int i = 0; i < 9; i++){
            blocks.add(new SudokuBlock());
            blocks.get(i).makeBlock(sudokuBoard, i);
        }
    }

    public void removeOnePossibleValueFromAllElementsInColumn(SudokuBoard sudokuBoard, int columnNumber, int value) {
        for(int i = 0; i < 9; i++) {
            sudokuBoard.board.get(i).getRow().get(columnNumber).removeElementFromPossibleValues(value);
        }
    }

    public void removeOnePossibleValueFromAllElementsInBlock(SudokuBoard sudokuBoard, int blockNumber, int value) {
        for(int i = 0; i < 9; i++) {
            sudokuBoard.getBlocks().get(blockNumber).getBlock().get(i).removeElementFromPossibleValues(value);
        }
    }

    public ArrayList<SudokuRow> getBoard() {
        return board;
    }

    public ArrayList<SudokuBlock> getBlocks() {
        return blocks;
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
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                System.out.print(" "+getBoard().get(i).getRow().get(j).possibleValues.size());
            }
            System.out.println();
        }
        return "";
    }

    public void setBoard(ArrayList<SudokuRow> board) {
        this.board = board;
    }

    public void setElementInRow(int rowNumber, int elementNumber, int elementValue) {
        board.get(rowNumber).setElement(elementNumber, elementValue);
    }
}
