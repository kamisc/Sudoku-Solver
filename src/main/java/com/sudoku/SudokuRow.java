package com.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuRow {
    private List<SudokuElement> rows = new ArrayList<>();

    public SudokuRow(List<SudokuElement> rows) {
        this.rows = rows;
    }

    public SudokuElement getElement(int column) {
        return rows.get(column);
    }

    public void addElement(int value) {
        rows.add(new SudokuElement(value));
    }
}
