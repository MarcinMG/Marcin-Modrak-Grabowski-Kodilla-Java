package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuRow {

    int rowNumber;
    ArrayList<SudokuElement> row = new ArrayList<>();

    public void makeRow() {
        for (int n = 0; n < 9; n++) {
            row.add(new SudokuElement());
            row.get(n).makePossibleValues();
        }
    }

    public ArrayList<SudokuElement> getRow() {
        return row;
    }

    public void showElements(int number) {
        System.out.println(row.get(number));
    }

    public void removeOnePossibleValueFromAllElementsInRow(int value) {
        for(int i = 0; i < 9; i++) {
            getRow().get(i).removeElementFromPossibleValues(value);
        }
    }

    @Override
    public String toString() {
        String formattedString1 = row.subList(0, 3).toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
        String formattedString2 = row.subList(3, 6).toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
        String formattedString3 = row.subList(6, 9).toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
        return formattedString1 + " |" + formattedString2 + " |" + formattedString3;
    }

    public void setElement(int elementNumber, int elementValue) {
        row.get(elementNumber).setValue(elementValue);
    }
}
