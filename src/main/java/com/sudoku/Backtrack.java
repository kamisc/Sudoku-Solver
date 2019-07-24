package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int positionCol;
    private int positoonRow;
    private int optionValue;

    public Backtrack(SudokuBoard sudokuBoard, int positionCol, int positoonRow, int optionValue) {
        this.sudokuBoard = sudokuBoard;
        this.positionCol = positionCol;
        this.positoonRow = positoonRow;
        this.optionValue = optionValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public int getPositoonRow() {
        return positoonRow;
    }

    public int getOptionValue() {
        return optionValue;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void setPositoonRow(int positoonRow) {
        this.positoonRow = positoonRow;
    }
}
