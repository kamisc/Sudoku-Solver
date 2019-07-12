package com.sudoku;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuElement {
    public static int EMPTY = 0;
    private int value;
    private List<Integer> possibleValues;

    public SudokuElement(int value, List<Integer> possibleValues) {
        this.value = value;
        this.possibleValues = possibleValues;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public String toString() {
        return "" + value + "";
    }
}
