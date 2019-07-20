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
                .map(SudokuElement::getValue)
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
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board.get(i).getElement(j).getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInPossibleValuesRow(int row, int value) {
        int checkRow = board.get(row).getRow().stream()
                .flatMap(p -> p.getPossibleValues().stream())
                .filter(v -> v.equals(value))
                .mapToInt(n -> 1)
                .sum();
        return checkRow > 0;
    }

    public boolean isInPossibleValuesColumn(int col, int value) {
        int checkColumn = board.stream()
                .flatMap(p -> p.getElement(col).getPossibleValues().stream())
                .filter(v -> v.equals(value))
                .mapToInt(n -> 1)
                .sum();
        return checkColumn > 0;
    }

    public boolean isInPossibleValuesBlock(int row, int col, int value) {
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board.get(i).getElement(j).getPossibleValues().get(j) == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeValueFromPossibleValuesInRow(int row, int value) {
        for(SudokuElement sudokuElement : board.get(row).getRow()) {
            List<Integer> possibleValues = sudokuElement.getPossibleValues();
            possibleValues.removeIf(v -> v == value);
        }
    }

    public void removeValueFromPossibleValuesInColumn(int col, int value) {
        for(SudokuRow sudokuRow : board) {
            List<Integer> possibleValues = sudokuRow.getElement(col).getPossibleValues();
            possibleValues.removeIf(v -> v == value);
        }
    }

    public void removeValueFromPossibleValuesInBlock(int row, int col, int value) {
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                removeValueFromPossibleValuesInColumn(j, value);
            }
        }
    }

    public void removeValueFromPossibleValues() {
        for(int i = 0; i < MAX_INDEX; i++) {
            for(int j = 0; j < MAX_INDEX; j++) {
                int elementValue = board.get(i).getElement(j).getValue();
                if(elementValue != 0) {
                    removeValueFromPossibleValuesInRow(i, elementValue);
                    removeValueFromPossibleValuesInColumn(j, elementValue);
                    removeValueFromPossibleValuesInBlock(i, j, elementValue);
                }
            }
        }
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

// Komórki w bloku