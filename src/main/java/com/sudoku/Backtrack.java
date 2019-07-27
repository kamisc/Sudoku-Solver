package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int positionCol;
    private int positionRow;
    private int optionValue;

    public Backtrack(SudokuBoard sudokuBoard, int positionCol, int positionRow, int optionValue) {
        this.sudokuBoard = sudokuBoard;
        this.positionCol = positionCol;
        this.positionRow = positionRow;
        this.optionValue = optionValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getOptionValue() {
        return optionValue;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }
}
