package com.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuElement {
    public static int EMPTY = 0;
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement(int value) {
        this.value = value;
        this.possibleValues = possibleValues();
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public List<Integer> possibleValues() {
        for(int i = SudokuBoard.MIN_INDEX; i <= SudokuBoard.MAX_INDEX; i++) {
            possibleValues.add(i);
        }
        return possibleValues;
    }

    @Override
    public String toString() {
        return "" + value + "";
    }
}
