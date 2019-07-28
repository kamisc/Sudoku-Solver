package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class SudokuGame {

    public static void main(String[] args) throws CloneNotSupportedException {
        Menu menu = new Menu();
        SudokuBoard sudokuBoard = new SudokuBoard();
        boolean gameFinished = false;

        // sudokuBoard.createBoard();

        testEasyBoard(sudokuBoard);

        //sudokuBoard.removeValueFromPossibleValues();

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();

            System.out.println(sudokuBoard);

            menu.menu(sudokuBoard);

            // System.out.println(sudokuBoard.deepCopy()/*.getRow(4).getElement(4).getPossibleValues()*/);
        }
    }

    public boolean resolveSudoku() {
        return false;
    }

    public static  void testEasyBoard(SudokuBoard sudokuBoard) {
        sudokuBoard.addElementToTheBoard(0, 0, 5);
        sudokuBoard.addElementToTheBoard(0, 1, 3);
        sudokuBoard.addElementToTheBoard(0, 4, 7);
        sudokuBoard.addElementToTheBoard(1, 0, 6);
        sudokuBoard.addElementToTheBoard(1, 3, 1);
        sudokuBoard.addElementToTheBoard(1, 4, 9);
        sudokuBoard.addElementToTheBoard(1, 5, 5);
        sudokuBoard.addElementToTheBoard(2, 1, 9);
        sudokuBoard.addElementToTheBoard(2, 2, 8);
        sudokuBoard.addElementToTheBoard(2, 7, 6);
        sudokuBoard.addElementToTheBoard(3, 0, 8);
        sudokuBoard.addElementToTheBoard(3, 4, 6);
        sudokuBoard.addElementToTheBoard(3, 8, 3);
        sudokuBoard.addElementToTheBoard(4, 0, 4);
        sudokuBoard.addElementToTheBoard(4, 3, 8);
        sudokuBoard.addElementToTheBoard(4, 5, 3);
        sudokuBoard.addElementToTheBoard(4, 8, 1);
        sudokuBoard.addElementToTheBoard(5, 0, 7);
        sudokuBoard.addElementToTheBoard(5, 4, 2);
        sudokuBoard.addElementToTheBoard(5, 8, 6);
        sudokuBoard.addElementToTheBoard(6, 1, 6);
        sudokuBoard.addElementToTheBoard(6, 6, 2);
        sudokuBoard.addElementToTheBoard(6, 7, 8);
        sudokuBoard.addElementToTheBoard(7, 3, 4);
        sudokuBoard.addElementToTheBoard(7, 4, 1);
        sudokuBoard.addElementToTheBoard(7, 5, 9);
        sudokuBoard.addElementToTheBoard(7, 8, 5);
        sudokuBoard.addElementToTheBoard(8, 4, 8);
        sudokuBoard.addElementToTheBoard(8, 7, 7);
        sudokuBoard.addElementToTheBoard(8, 8, 9);
    }

    public static void testHardBoard(SudokuBoard sudokuBoard) {
        sudokuBoard.addElementToTheBoard(0, 0, 7);
        sudokuBoard.addElementToTheBoard(0, 1, 8);
        sudokuBoard.addElementToTheBoard(0, 3, 2);
        sudokuBoard.addElementToTheBoard(0, 8, 1);

        sudokuBoard.addElementToTheBoard(2, 2, 1);
        sudokuBoard.addElementToTheBoard(2, 3, 7);
        sudokuBoard.addElementToTheBoard(2, 5, 8);
        sudokuBoard.addElementToTheBoard(2, 6, 5);

        sudokuBoard.addElementToTheBoard(3, 0, 5);
        sudokuBoard.addElementToTheBoard(3, 2, 9);
        sudokuBoard.addElementToTheBoard(3, 8, 4);

        sudokuBoard.addElementToTheBoard(4, 1, 7);
        sudokuBoard.addElementToTheBoard(4, 4, 6);
        sudokuBoard.addElementToTheBoard(4, 7, 3);

        sudokuBoard.addElementToTheBoard(5, 0, 1);
        sudokuBoard.addElementToTheBoard(5, 6, 2);
        sudokuBoard.addElementToTheBoard(5, 8, 8);

        sudokuBoard.addElementToTheBoard(6, 2, 8);
        sudokuBoard.addElementToTheBoard(6, 3, 1);
        sudokuBoard.addElementToTheBoard(6, 5, 3);
        sudokuBoard.addElementToTheBoard(6, 6, 9);

        sudokuBoard.addElementToTheBoard(8, 0, 6);
        sudokuBoard.addElementToTheBoard(8, 5, 4);
        sudokuBoard.addElementToTheBoard(8, 7, 7);
        sudokuBoard.addElementToTheBoard(8, 8, 3);
    }

    public static void testMediumBoard(SudokuBoard sudokuBoard) {
        sudokuBoard.addElementToTheBoard(0, 0, 1);
        sudokuBoard.addElementToTheBoard(0, 1, 4);
        sudokuBoard.addElementToTheBoard(0, 3, 3);
        sudokuBoard.addElementToTheBoard(0, 5, 2);

        sudokuBoard.addElementToTheBoard(1, 2, 5);
        sudokuBoard.addElementToTheBoard(1, 4, 9);
        sudokuBoard.addElementToTheBoard(1, 8, 3);

        sudokuBoard.addElementToTheBoard(2, 2, 3);
        sudokuBoard.addElementToTheBoard(2, 4, 8);
        sudokuBoard.addElementToTheBoard(2, 6, 6);
        sudokuBoard.addElementToTheBoard(2, 8, 1);

        sudokuBoard.addElementToTheBoard(3, 1, 7);
        sudokuBoard.addElementToTheBoard(3, 4, 4);
        sudokuBoard.addElementToTheBoard(3, 6, 2);
        sudokuBoard.addElementToTheBoard(3, 8, 5);

        sudokuBoard.addElementToTheBoard(4, 1, 3);
        sudokuBoard.addElementToTheBoard(4, 7, 6);

        sudokuBoard.addElementToTheBoard(5, 0, 5);
        sudokuBoard.addElementToTheBoard(5, 2, 1);
        sudokuBoard.addElementToTheBoard(5, 4, 2);
        sudokuBoard.addElementToTheBoard(5, 7, 7);

        sudokuBoard.addElementToTheBoard(6, 0, 2);
        sudokuBoard.addElementToTheBoard(6, 2, 4);
        sudokuBoard.addElementToTheBoard(6, 4, 3);
        sudokuBoard.addElementToTheBoard(6, 6, 5);

        sudokuBoard.addElementToTheBoard(7, 0, 9);
        sudokuBoard.addElementToTheBoard(7, 4, 1);
        sudokuBoard.addElementToTheBoard(7, 6, 7);

        sudokuBoard.addElementToTheBoard(8, 3, 8);
        sudokuBoard.addElementToTheBoard(8, 5, 9);
        sudokuBoard.addElementToTheBoard(8, 7, 4);
        sudokuBoard.addElementToTheBoard(8, 8, 2);
    }
}
