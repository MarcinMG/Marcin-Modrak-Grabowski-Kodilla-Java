package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    public SudokuBoard createEmptyBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.makeBoard();
        return sudokuBoard;
    }

    public void showSudokuBoard(SudokuBoard sudokuBoard) {
        String formattedString = sudokuBoard.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        System.out.println(formattedString);
    }

    public void fillSudoku(SudokuBoard sudokuBoard) {
        Boolean endFillSudoku;
        do {
            endFillSudoku = setElement(sudokuBoard);
        }while (!endFillSudoku);
    }

    public Boolean setElement(SudokuBoard sudokuBoard) {
        System.out.println("Wypełnij Sudoku podając współrzędne: wiersz 1-9, kolumna 1-9, wartość 1-9, np 239[ENTER]: ");
        System.out.println("Wpisz SUDOKU aby rozwiązać");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean checkData;
        do {
            userInput = scanner.next();
            if (userInput.equals("sudoku")) {
                return true;
            }
            int coOrdinetesAndValue = Integer.parseInt(userInput);
            int rowNumber = coOrdinetesAndValue/100 % 10;
            int columnNumber = coOrdinetesAndValue/10 % 10;
            int value = coOrdinetesAndValue % 10;
            checkData = ((coOrdinetesAndValue < 111) || (coOrdinetesAndValue > 999));
            if ((checkData) || (coOrdinetesAndValue % 10) == 0) {
                System.out.println("Błędne dane, spóbuj jeszcze raz: ");
            }
            else if (sudokuBoard.getBoard().get(rowNumber-1).getRow().get(columnNumber-1).getValue() != -1) {
                System.out.println("Pole juz wypełnione, wybierz inne pole");
            }
            else if (checkValue(sudokuBoard, rowNumber, columnNumber, value)) {
                System.out.println("Podaj inną wartośc dla tych współrzędnych");
            }
            else {
                sudokuBoard.setElementInRow(rowNumber-1,columnNumber-1, value);
                sudokuBoard.getBoard().get(rowNumber-1).removeOnePossibleValueFromAllElementsInRow(value);
                sudokuBoard.removeOnePossibleValueFromAllElementsInColumn(sudokuBoard, columnNumber-1, value);
                sudokuBoard.removeOnePossibleValueFromAllElementsInBlock(sudokuBoard,
                        calculateBlockNumber(rowNumber-1, columnNumber-1), value);
                showSudokuBoard(sudokuBoard);
            }
        } while (checkData);
        return false;
    }


    public boolean resolveSudoku(SudokuBoard sudokuBoard) {

        int row = 0;
        int col = 0;
        int[] solvedOrNot = numberUnassigned(sudokuBoard, row, col);

        if(solvedOrNot[0] == 0) {
            return true;
        }

        row = solvedOrNot[1];
        col = solvedOrNot[2];

                if (sudokuBoard.board.get(row).row.get(col).possibleValues.size() == 1) {
                    int value = sudokuBoard.board.get(row).row.get(col).possibleValues.get(0);
                    sudokuBoard.setElementInRow(row, col, value);
                    sudokuBoard.getBoard().get(row).removeOnePossibleValueFromAllElementsInRow(value);
                    sudokuBoard.removeOnePossibleValueFromAllElementsInColumn(sudokuBoard, col, value);
                    int row_start = (row / 3) * 3;
                    int col_start = (col / 3) * 3;
                    for (int i = row_start; i < row_start + 3; i++) {
                        for (int j = col_start; j < col_start + 3; j++) {
                            sudokuBoard.getBlocks().get(i).getBlock().get(j).removeElementFromPossibleValues(value);
                        }
                    }
                }



        for(int i = 1; i <= 9; i++) {
            if(isSafe(sudokuBoard, i, row, col)){
                sudokuBoard.setElementInRow(row, col, i);
                sudokuBoard.getBoard().get(row).removeOnePossibleValueFromAllElementsInRow(i);
                sudokuBoard.removeOnePossibleValueFromAllElementsInColumn(sudokuBoard, col, i);
                int row_start = (row/3)*3;
                int col_start = (col/3)*3;
                for(int x = row_start; x < row_start+3; x++) {
                    for(int y = col_start; y < col_start+3; y++) {
                        sudokuBoard.getBlocks().get(x).getBlock().get(y).removeElementFromPossibleValues(i);
                    }
                }
                if(resolveSudoku(sudokuBoard)) {
                    return true;
                }
                sudokuBoard.getBoard().get(row).getRow().get(col).setValue(-1);
            }
        }
        return false;

//        showSudokuBoard(sudokuBoard);
//        Scanner scanner = new Scanner(System.in);
//        String exitGame;
//        do {
//            System.out.println("r - od nowa  z - zakończ");
//            exitGame = scanner.next();
//        } while ((!exitGame.equals("r")) && (!(exitGame.equals("z"))));
//        return (exitGame.equals("z"));
    }

    public static int[] numberUnassigned(SudokuBoard sudokuBoard, int row, int col) {
        int numberUnassign = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudokuBoard.getBoard().get(i).getRow().get(j).getValue() == -1) {
                    row = i;
                    col = j;
                    numberUnassign = 1;
                    int[] a = {numberUnassign, row, col};
                    return a;
                }
            }
        }
        int[] a = {numberUnassign, -1, -1};
        return a;
    }

    public static boolean isSafe(SudokuBoard sudokuBoard, int n, int r, int c) {
        for(int i = 0; i < 9; i++) {
            if(sudokuBoard.getBoard().get(r).getRow().get(i).getValue() == n) {
                return false;
            }
        }
        for(int i = 0; i < 9; i++) {
            if(sudokuBoard.getBoard().get(i).getRow().get(c).getValue() == n) {
                return false;
            }
        }
        int row_start = (r/3)*3;
        int col_start = (c/3)*3;
        for(int i = row_start; i < row_start+3; i++) {
            for(int j = col_start; j < col_start+3; j++) {
                if(sudokuBoard.getBoard().get(i).getRow().get(j).getValue() == n) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkValue(SudokuBoard sudokuBoard, int rowNumber, int columnNumber, int elementValue) {
        int blockNumber = calculateBlockNumber(rowNumber-1, columnNumber-1);
        for(int i = 0; i < 9; i++ ) {
          if((sudokuBoard.getBoard().get(rowNumber-1).getRow().get(i).getValue() != -1)  &&
               (sudokuBoard.getBoard().get(rowNumber-1).getRow().get(i).getValue() == elementValue)) {
                  return true;
          }
          else if((sudokuBoard.getBoard().get(i).getRow().get(columnNumber-1).getValue() != -1) &&
                (sudokuBoard.getBoard().get(i).getRow().get(columnNumber-1).getValue() == elementValue)) {
                  return true;
          }
          else if(sudokuBoard.getBlocks().get(blockNumber).getBlock().get(i).getValue() == elementValue) {
                  return true;
                }
        }
        return false;
    }

    public boolean checkPossibleValue(SudokuBoard sudokuBoard, int row, int column, int value) {
        int blockNumber = calculateBlockNumber(row-1, column-1);
        for(int i = 0; i < 9 && i != row; i++) {
            for (int x = 0; x < sudokuBoard.getBoard().get(row - 1).getRow().get(i).possibleValues.size(); x++) {
                if (sudokuBoard.getBoard().get(row - 1).getRow().get(i).possibleValues.get(x) == value) {
                    return true;
                }
            }
        }
        for(int i = 0; i < 9 && i != column; i++) {
            for (int x = 0; x < sudokuBoard.getBoard().get(i).getRow().get(column - 1).possibleValues.size(); x++) {
                if (sudokuBoard.getBoard().get(i).getRow().get(column - 1).possibleValues.get(x) == value) {
                    return true;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            for (int x = 0; x < sudokuBoard.getBlocks().get(blockNumber).getBlock().get(i).possibleValues.size(); x++) {
                if (sudokuBoard.getBlocks().get(blockNumber).getBlock().get(i).possibleValues.get(x) == value
                        && (sudokuBoard.getBoard().get(row).getRow().get(column).hashCode()
                        != sudokuBoard.getBlocks().get(blockNumber).getBlock().get(i).hashCode())) {
    //!sudokuBoard.getBoard().get(row).getRow().get(column).equals(sudokuBoard.getBlocks().get(blockNumber).getBlock().get(i))
                    return true;
                }
            }
        }

        return false;
    }

    public int calculateBlockNumber(int rowNumber, int columnNumber) {
        if(rowNumber < 3 && columnNumber < 3) {
            return 0;
        }
        else if(rowNumber < 3 && columnNumber >= 3 && columnNumber < 6) {
            return 1;
        }
        else if(rowNumber < 3 && columnNumber >= 6 && columnNumber < 9) {
            return 2;
        }
        else if(rowNumber >= 3 && rowNumber < 6 && columnNumber < 3) {
            return 3;
        }
        else if(rowNumber >= 3 && rowNumber < 6 && columnNumber >= 3 && columnNumber < 6 ) {
            return 4;
        }
        else if(rowNumber >= 3 && rowNumber < 6 && columnNumber >= 6 && columnNumber < 9) {
            return 5;
        }
        else if(rowNumber >= 6 && rowNumber < 9 && columnNumber < 3) {
            return 6;
        }
        else if(rowNumber >= 6 && rowNumber < 9 && columnNumber >= 3 && columnNumber < 6) {
            return 7;
        }
        else
            return 8;
    }
}
