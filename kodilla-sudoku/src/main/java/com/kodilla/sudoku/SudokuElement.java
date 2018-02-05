package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuElement {

    private int value = 1;
    ArrayList<Integer> possibleValues = new ArrayList<>();

    public void makePossibleValues() {
        for (int n = 1; n <= 9; n++) {
            possibleValues.add(n);
        }
    }

    public void showPossibleValues() {
        for (Integer element : possibleValues ) {
            System.out.print(element);
        }
    }

    @Override
    public String toString() {
        return  " " + value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
