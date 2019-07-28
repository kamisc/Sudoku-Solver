package com.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Author Kamil Seweryn
 */

public class SudokuBoard extends Prototype {
    private List<SudokuRow> board = new ArrayList<>();
    public List<Backtrack> backtrack = new ArrayList<>();

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

    public void addElementToTheBoard(int row, int col, int value) {
        board.get(row).addElement(col, value);
    }

    public boolean isInRow(int row, int value) {
        long checkRow = board.get(row).getRow().stream()
                .map(SudokuElement::getValue)
                .filter(v -> v.equals(value))
                .count();
        return checkRow > 0;
    }

    public boolean isInColumn(int col, int value) {
        long checkColumn = board.stream()
                .map(c -> c.getElement(col).getValue())
                .filter(v -> v.equals(value))
                .count();
        return checkColumn > 0;
    }

    public boolean isInBlock(int row, int col, int value) {
        int r = row - row % 3;
        int c = col - col % 3;

        return IntStream.range(r, r + 3)
                .anyMatch(i -> IntStream.range(c, c + 3)
                        .anyMatch(j -> board.get(i).getElement(j).getValue() == value));
    }

    public boolean isInRowColumnBlock(int row, int col, int value) {
        return isInRow(row, value) || isInColumn(col, value) || isInBlock(row, col, value);
    }

    public boolean isInPossibleValuesRow(int row, int value) {
        long checkRow = board.get(row).getRow().stream()
                .flatMap(p -> p.getPossibleValues().stream())
                .filter(v -> v.equals(value))
                .count();
        return checkRow > 0;
    }

    public boolean isInPossibleValuesColumn(int col, int value) {
        long checkColumn = board.stream()
                .flatMap(p -> p.getElement(col).getPossibleValues().stream())
                .filter(v -> v.equals(value))
                .count();
        return checkColumn > 0;
    }

    public boolean isInPossibleValuesBlock(int row, int col, int value) {
        int r = row - row % 3;
        int c = col - col % 3;

        return IntStream.range(r, r + 3)
                .anyMatch(i -> IntStream.range(c, c + 3)
                        .anyMatch(j -> board.get(i).getElement(j).getPossibleValues().contains(value)));
    }

    public boolean isInPossibleValuesRowColumnBlock(int row, int col, int value) {
        return isInPossibleValuesRow(row, value) || isInPossibleValuesColumn(col,value) || isInPossibleValuesBlock(row, col, value);
    }

    public void removeValueFromPossibleValuesInRow(int row, int value) {
        for(SudokuElement sudokuElement : getRow(row).getRow()) {
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

        for(int i = 0; i < 3; i++) {
            SudokuBoard rows = new SudokuBoard();
            rows.addRow(getRow(r + i));
            for(int j = c; j < c + 3; j++) {
                rows.removeValueFromPossibleValuesInColumn(j, value);
            }
        }
    }

    public void removeValueFromPossibleValues() {
        for(int i = 0; i < MAX_INDEX; i++) {
            for(int j = 0; j < MAX_INDEX; j++) {
                int elementValue = getRow(i).getElement(j).getValue();
                if(elementValue > 0) {
                    removeValueFromPossibleValuesInRow(i, elementValue);
                    removeValueFromPossibleValuesInColumn(j, elementValue);
                    removeValueFromPossibleValuesInBlock(i, j, elementValue);
                }
            }
        }
    }

    public PositionDto findFirstEmptyElement() {

        PositionDto positionDto = new PositionDto(SudokuElement.EMPTY, SudokuElement.EMPTY);

        for(int i = MIN_INDEX - 1; i < MAX_INDEX; i++) {
            for(int j = MIN_INDEX - 1; j < MAX_INDEX; j++) {
                if(getRow(i).getElement(j).getValue() == 0) {
                    positionDto.setEmptyRow(i);
                    positionDto.setEmptyColumn(j);
                    return positionDto;
                }
            }
        }
        return positionDto;
    }

    public boolean checkIsEmptyElement() {
        for(int i = MIN_INDEX - 1; i < MAX_INDEX; i++) {
            for(int j = MIN_INDEX - 1; j < MAX_INDEX; j++) {
                if(getRow(i).getElement(j).getValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addElementIfIsTheOnlyOneInPossibleValues() {
        for(int i = MIN_INDEX - 1; i < MAX_INDEX; i++) {
            for(int j = MIN_INDEX - 1; j < MAX_INDEX; j++) {
                if(board.get(i).getElement(j).getPossibleValues().size() == 1
                        && board.get(i).getElement(j).getValue() == 0) {
                    int possibleValue = board.get(i).getElement(j).getPossibleValues().get(0);

                    if(!(isInRowColumnBlock(i, j, possibleValue))) {
                        addElementToTheBoard(i, j, board.get(i).getElement(j).getPossibleValues().get(0));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addElementIfIsPossibleValueOrPossibleInOtherCells() {
        for(int i = MIN_INDEX - 1; i < MAX_INDEX; i++) {
            for(int j = MIN_INDEX - 1; j < MAX_INDEX; j++) {
                for(Integer value : getRow(i).getElement(j).getPossibleValues()) {
                    if(!(isInRowColumnBlock(i, j, value) || isInPossibleValuesRowColumnBlock(i, j, value) )) {
                        addElementToTheBoard(i, j, value);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void guessValue(int row, int col) throws CloneNotSupportedException {
        SudokuElement sudokuElement = getRow(row).getElement(col);
        PositionDto positionDto = new PositionDto(row, col);

        if(sudokuElement.getPossibleValues().size() > 0) {
            int value = sudokuElement.getPossibleValues().get(0);
            backtrack.add(new Backtrack(deepCopy(), positionDto, value));
            addElementToTheBoard(row, col, value);
        }
    }

    public void solveSudoku() throws CloneNotSupportedException {
        boolean isNotHard = true;

        while(isNotHard) {
            removeValueFromPossibleValues();
            boolean checkOne = addElementIfIsTheOnlyOneInPossibleValues();
            boolean checkTwo = addElementIfIsPossibleValueOrPossibleInOtherCells();

            if(!(checkOne || checkTwo)) {
                isNotHard = false;
            }
        }

        if(!isNotHard) {
            int row = findFirstEmptyElement().getEmptyRow();
            int col = findFirstEmptyElement().getEmptyColumn();
            guessValue(row, col);
            /*if(!backtrack.isEmpty()) {
                backtrack.remove(0);
            }*/
            System.out.println(findFirstEmptyElement().getEmptyRow() + " : " + findFirstEmptyElement().getEmptyColumn());
            System.out.println(getRow(1).getElement(8).getPossibleValues());
            System.out.println(backtrack.get(0).getSudokuBoard().getRow(1).getElement(8).getPossibleValues());
            System.out.println(backtrack.size());
        }
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = (SudokuBoard)super.clone();
        clonedSudokuBoard.board = new ArrayList<>();

        for(SudokuRow sudokuRow : board) {
            List<SudokuElement> clonedElementList = new ArrayList<>();
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.setRow(clonedElementList);

            for(SudokuElement sudokuElement : sudokuRow.getRow()) {
                List<Integer> clonedPossibleValues = new ArrayList<>();

                clonedPossibleValues.addAll(sudokuElement.getPossibleValues());

                SudokuElement clonedElement = new SudokuElement(sudokuElement.getValue());
                clonedElement.setPossibleValues(clonedPossibleValues);
                clonedElementList.add(clonedElement);
            }
            clonedSudokuBoard.addRow(clonedRow);
        }
        return clonedSudokuBoard;
    }

    @Override
    public String toString() {
        StringBuilder displayBoard = new StringBuilder();
        System.out.println("    " +  1 + "   " + 2 + "   " + 3 + "   " + 4 + "   " + 5 + "   " + 6 + "   " + 7 + "   " + 8 + "   " + 9);
        for(int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            displayBoard.append("  -------------------------------------" + "\n").append(i);
            for(int j = MIN_INDEX; j <= MAX_INDEX; j++) {
                displayBoard.append(" | ").append(board.get(i - 1).getElement(j - 1));
            }
            displayBoard.append(" |\n");
        }
        return displayBoard.toString();
    }
}

// Analogiczna metoda przechodząca po wszystkich komórkach i sprawdza, czy jest wartość (empty), czy jest co
// najmniej jedną wartość. Jeżeli nie ma to wyjątek - łapie przy miejscu gdzie deepCopy, po złapaniu, przywracam
// skopiowany board