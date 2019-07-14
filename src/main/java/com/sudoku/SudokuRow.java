package com.sudoku;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuRow {
    private List<SudokuElement> row;

    public SudokuRow(List<SudokuElement> row) {
        this.row = row;
    }

    public List<SudokuElement> getRow() {
        return row;
    }

    public SudokuElement getElement(int column) {
        return row.get(column);
    }

    public void addElement(int column, int value) {
        row.add(column, new SudokuElement(value));
    }
}
