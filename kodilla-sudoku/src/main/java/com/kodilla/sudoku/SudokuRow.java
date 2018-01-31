package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuRow {

    int rowNumber;
    public static int EMPTY = -1;
    ArrayList<SudokuElement> row = new ArrayList<>();

    public void makeRow() {
        for (int n = 0; n < 9; n++) {
            row.add(new SudokuElement());
            row.get(n).makePossibleValues();
        }
    }

    public void showElements(int number) {
        System.out.println(row.get(number));
    }

    @Override
    public String toString() {
        return "SudokuRow{" + '\n' +
                "rowNumber=" + rowNumber +
                ", row=" + row +
                '}';
    }

    public void setElement(int elementNumber, int elementValue) {
        row.get(elementNumber).setValue(elementValue);
    }
}
