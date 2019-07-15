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
            board.add(new SudokuRow());
        }
        return board;
    }

    public void addElementToTheBoard(int col, int row, int value) {
        board.get(row).addElement(col,value);
    }

    public boolean isInRow(int row, int value) {
        int checkRow = board.get(row).getRow().stream()
                .map(r -> r.getValue())
                .filter(v -> v.equals(value))
                .mapToInt(n -> 1)
                .sum();
        return checkRow > 0;
    }

    public boolean isInColumn(int col, int value) {
        int checkColumn = board.stream()
                .map(c -> c.getElement(col).getValue())
                .filter(v -> v.equals(value))
                .mapToInt(n -> 1)
                .sum();
        return checkColumn > 0;
    }

    public boolean isInBlock(int row, int col, int value) {
        return true;
    }

    @Override
    public String toString() {
        String displayBoard = "";
        System.out.println("    " +  1 + "   " + 2 + "   " + 3 + "   " + 4 + "   " + 5 + "   " + 6 + "   " + 7 + "   " + 8 + "   " + 9);
        for(int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            displayBoard += "  -------------------------------------" + "\n" + i;
            for(int j = MIN_INDEX; j <= MAX_INDEX; j++) {
                displayBoard += " | " + board.get(i-1).getElement(j-1);
            }
            displayBoard += " |\n";
        }
        return displayBoard;
    }
}
