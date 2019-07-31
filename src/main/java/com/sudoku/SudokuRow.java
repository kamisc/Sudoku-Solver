package com.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList<>();

    public SudokuRow() {
        for(int i = SudokuBoard.MIN_INDEX; i <= SudokuBoard.MAX_INDEX; i++) {
            row.add(i - 1, new SudokuElement(SudokuElement.EMPTY));
        }
    }

    public List<SudokuElement> getRow() {
        return row;
    }

    public SudokuElement getElement(int column) {
        return row.get(column);
    }

    public void addElement(int column, int value) {
        row.set(column, new SudokuElement(value));
    }

    public void setRow(List<SudokuElement> row) {
        this.row = row;
    }
}
