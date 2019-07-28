package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private PositionDto positionDto;
    private int optionValue;

    public Backtrack(SudokuBoard sudokuBoard, PositionDto positionDto, int optionValue) {
        this.sudokuBoard = sudokuBoard;
        this.positionDto = positionDto;
        this.optionValue = optionValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public PositionDto getPositionDto() {
        return positionDto;
    }

    public int getOptionValue() {
        return optionValue;
    }

    @Override
    public String toString() {
        return "Backtrack{" +
                "sudokuBoard=" + sudokuBoard +
                ", positionDto=" + positionDto +
                ", optionValue=" + optionValue +
                '}';
    }
}
