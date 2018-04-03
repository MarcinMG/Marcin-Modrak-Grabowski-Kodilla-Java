package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuElement {

    public static int EMPTY = -1;
    private int value = EMPTY;
    ArrayList<Integer> possibleValues = new ArrayList<>();

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public int getValue() {
        return value;
    }

    public void makePossibleValues() {
        for (int n = 1; n <= 9; n++) {
            possibleValues.add(n);
        }
    }

    public void removeElementFromPossibleValues(int value) {
        for(int i = 0; i < possibleValues.size(); i++ ) {
            if (possibleValues.get(i) == value) {
                possibleValues.remove(i);
            }
        }
    }

    public void showPossibleValues() {
        for (Integer element : possibleValues ) {
            System.out.print(element);
        }
    }

    @Override
    public String toString() {
        if(value != EMPTY) {
            return " " + value;
        }
        else {
            return "  ";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement that = (SudokuElement) o;

        if (value != that.value) return false;
        return possibleValues != null ? possibleValues.equals(that.possibleValues) : that.possibleValues == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (possibleValues != null ? possibleValues.hashCode() : 0);
        return result;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
