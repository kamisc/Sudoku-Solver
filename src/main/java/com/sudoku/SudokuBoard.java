package com.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuBoard {
    private List<SudokuRow> board = new ArrayList<>();
    private final static int MIN_INDEX = 0;
    private final static int MAX_INDEX = 9;

    public SudokuBoard() {

    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public SudokuRow getRow(int row) {
        return board.get(row);
    }

    public void addRow(SudokuRow sudokuRow) {
        board.add(sudokuRow);
    }

    @Override
    public String toString() {
        String displayBoard = "";
        for(int i = MIN_INDEX; i < MAX_INDEX; i++) {
            System.out.println("---------------------------------------");
            for(int j = MIN_INDEX; j < MAX_INDEX; j++) {
                System.out.print(" | " + SudokuElement.EMPTY); // board.get(i).getElement(j)
            }
            System.out.print(" |\n");
        }
        return displayBoard;
    }
}
