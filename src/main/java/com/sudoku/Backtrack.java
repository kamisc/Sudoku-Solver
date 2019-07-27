package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int positionCol;
    private int positonRow;
    private int optionValue;

    public Backtrack(SudokuBoard sudokuBoard, int positionCol, int positonRow, int optionValue) {
        this.sudokuBoard = sudokuBoard;
        this.positionCol = positionCol;
        this.positonRow = positonRow;
        this.optionValue = optionValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public int getPositonRow() {
        return positonRow;
    }

    public int getOptionValue() {
        return optionValue;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void setPositonRow(int positoonRow) {
        this.positonRow = positoonRow;
    }
}
