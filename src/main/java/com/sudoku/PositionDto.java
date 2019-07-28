package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class PositionDto {
    private int emptyRow;
    private int emptyColumn;

    public PositionDto(int emptyRow, int emptyColumn) {
        this.emptyRow = emptyRow;
        this.emptyColumn = emptyColumn;
    }

    public int getEmptyRow() {
        return emptyRow;
    }

    public void setEmptyRow(int emptyRow) {
        this.emptyRow = emptyRow;
    }

    public int getEmptyColumn() {
        return emptyColumn;
    }

    public void setEmptyColumn(int emptyColumn) {
        this.emptyColumn = emptyColumn;
    }

    @Override
    public String toString() {
        return "row :" + emptyRow + " : col: " + emptyColumn;
    }
}
