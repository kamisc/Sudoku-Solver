package com.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuBoard {
    private List<SudokuRow> board = new ArrayList<>();
    public final static int MIN_INDEX = 1;
    public final static int MAX_INDEX = 9;

    public SudokuBoard() {
        createBoard();
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

    public List<SudokuRow> createBoard() {
        for(int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            board.add(new SudokuRow(sudokuElements()));
        }
        return board;
    }

    public List<SudokuElement> sudokuElements() {
        List<SudokuElement> sudokuElements = new ArrayList<>();
        for(int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            sudokuElements.add(new SudokuElement(SudokuElement.EMPTY));
        }
        return sudokuElements;
    }

    @Override
    public String toString() {
        String displayBoard = "";
        for(int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            displayBoard += "---------------------------------------" + "\n";
            for(int j = MIN_INDEX; j <= MAX_INDEX; j++) {
                displayBoard += " | " + board.get(i-1).getElement(j-1);
            }
            displayBoard += " |\n";
        }
        return displayBoard;
    }
}
