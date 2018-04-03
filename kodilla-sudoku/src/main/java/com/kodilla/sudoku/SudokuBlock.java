package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuBlock {

    int blockNumber;
    ArrayList<SudokuElement> block = new ArrayList<>();

    public void makeBlock(SudokuBoard sudokuBoard, int blockNumber) {
            switch(blockNumber) {
                case 0:
                    for(int row = 0; row < 3; row++)
                        for (int column = 0; column < 3; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 1:
                    for(int row = 0; row < 3; row++)
                        for (int column = 3; column < 6; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 2:
                    for(int row = 0; row < 3; row++)
                        for (int column = 6; column < 9; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 3:
                    for(int row = 3; row < 6; row++)
                        for (int column = 0; column < 3; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 4:
                    for(int row = 3; row < 6; row++)
                        for (int column = 3; column < 6; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 5:
                    for(int row = 3; row < 6; row++)
                        for (int column = 6; column < 9; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 6:
                    for(int row = 6; row < 9; row++)
                        for (int column = 0; column < 3; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 7:
                    for(int row = 6; row < 9; row++)
                        for (int column = 3; column < 6; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
                case 8:
                    for(int row = 6; row < 9; row++)
                        for (int column = 6; column < 9; column++)
                            block.add(sudokuBoard.getBoard().get(row).getRow().get(column));
            }
    }

    public ArrayList<SudokuElement> getBlock() {
        return block;
    }
}
