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

        testHardBoard(sudokuBoard);
        sudokuBoard.removeValueFromPossibleValues();

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();

            System.out.println(sudokuBoard);

            menu.menu(sudokuBoard);
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

    public static void testEvilBoard(SudokuBoard sudokuBoard) {
        sudokuBoard.addElementToTheBoard(0, 0, 7);
        sudokuBoard.addElementToTheBoard(0, 4, 3);
        sudokuBoard.addElementToTheBoard(0, 8, 1);

        sudokuBoard.addElementToTheBoard(1, 3, 1);
        sudokuBoard.addElementToTheBoard(1, 4, 7);
        sudokuBoard.addElementToTheBoard(1, 5, 8);

        sudokuBoard.addElementToTheBoard(2, 2, 5);
        sudokuBoard.addElementToTheBoard(2, 6, 2);

        sudokuBoard.addElementToTheBoard(3, 1, 2);
        sudokuBoard.addElementToTheBoard(3, 2, 6);
        sudokuBoard.addElementToTheBoard(3, 6, 4);
        sudokuBoard.addElementToTheBoard(3, 7, 9);

        sudokuBoard.addElementToTheBoard(5, 1, 8);
        sudokuBoard.addElementToTheBoard(5, 2, 4);
        sudokuBoard.addElementToTheBoard(5, 6, 7);
        sudokuBoard.addElementToTheBoard(5, 7, 2);

        sudokuBoard.addElementToTheBoard(6, 2, 3);
        sudokuBoard.addElementToTheBoard(6, 6, 6);

        sudokuBoard.addElementToTheBoard(7, 3, 3);
        sudokuBoard.addElementToTheBoard(7, 4, 5);
        sudokuBoard.addElementToTheBoard(7, 5, 9);

        sudokuBoard.addElementToTheBoard(8, 0, 4);
        sudokuBoard.addElementToTheBoard(8, 4, 1);
        sudokuBoard.addElementToTheBoard(8, 8, 9);
    }

    public static void testOtherHardBoard(SudokuBoard sudokuBoard) {
        sudokuBoard.addElementToTheBoard(0, 0, 6);
        sudokuBoard.addElementToTheBoard(0, 2, 8);
        sudokuBoard.addElementToTheBoard(0, 3, 1);
        sudokuBoard.addElementToTheBoard(0, 6, 5);

        sudokuBoard.addElementToTheBoard(1, 2, 1);
        sudokuBoard.addElementToTheBoard(1, 4, 3);
        sudokuBoard.addElementToTheBoard(1, 8, 4);

        sudokuBoard.addElementToTheBoard(2, 1, 2);
        sudokuBoard.addElementToTheBoard(2, 4, 9);
        sudokuBoard.addElementToTheBoard(2, 5, 5);
        sudokuBoard.addElementToTheBoard(2, 6, 7);
        sudokuBoard.addElementToTheBoard(2, 7, 6);

        sudokuBoard.addElementToTheBoard(3, 2, 5);
        sudokuBoard.addElementToTheBoard(3, 4, 9);
        sudokuBoard.addElementToTheBoard(3, 6, 9);

        sudokuBoard.addElementToTheBoard(4, 1, 4);
        sudokuBoard.addElementToTheBoard(4, 2, 3);
        sudokuBoard.addElementToTheBoard(4, 5, 9);
        sudokuBoard.addElementToTheBoard(4, 7, 1);
        sudokuBoard.addElementToTheBoard(4, 8, 8);

        sudokuBoard.addElementToTheBoard(5, 0, 8);
        sudokuBoard.addElementToTheBoard(5, 3, 6);
        sudokuBoard.addElementToTheBoard(5, 4, 1);
        sudokuBoard.addElementToTheBoard(5, 8, 2);

        sudokuBoard.addElementToTheBoard(6, 1, 3);
        sudokuBoard.addElementToTheBoard(6, 5, 2);
        sudokuBoard.addElementToTheBoard(6, 6, 1);
        sudokuBoard.addElementToTheBoard(6, 8, 5);

        sudokuBoard.addElementToTheBoard(7, 0, 5);
        sudokuBoard.addElementToTheBoard(7, 2, 2);
        sudokuBoard.addElementToTheBoard(7, 5, 7);
        sudokuBoard.addElementToTheBoard(7, 6, 3);

        sudokuBoard.addElementToTheBoard(8, 1, 8);
        sudokuBoard.addElementToTheBoard(8, 3, 3);
        sudokuBoard.addElementToTheBoard(8, 4, 5);
        sudokuBoard.addElementToTheBoard(8, 8, 9);
    }

    public static void testOtherBoardHard(SudokuBoard sudokuBoard) {
        sudokuBoard.addElementToTheBoard(0, 4, 6);
        sudokuBoard.addElementToTheBoard(0, 6, 7);

        sudokuBoard.addElementToTheBoard(1, 3, 4);

        sudokuBoard.addElementToTheBoard(2, 0, 5);
        sudokuBoard.addElementToTheBoard(2, 3, 3);
        sudokuBoard.addElementToTheBoard(2, 4, 1);

        sudokuBoard.addElementToTheBoard(3, 1, 1);
        sudokuBoard.addElementToTheBoard(3, 2, 9);
        sudokuBoard.addElementToTheBoard(3, 7, 8);
        sudokuBoard.addElementToTheBoard(3, 8, 3);

        sudokuBoard.addElementToTheBoard(4, 1, 5);
        sudokuBoard.addElementToTheBoard(4, 8, 4);

        sudokuBoard.addElementToTheBoard(5, 1, 8);
        sudokuBoard.addElementToTheBoard(5, 2, 4);
        sudokuBoard.addElementToTheBoard(5, 3, 6);
        sudokuBoard.addElementToTheBoard(5, 8, 5);

        sudokuBoard.addElementToTheBoard(6, 3, 9);
        sudokuBoard.addElementToTheBoard(6, 4, 5);

        sudokuBoard.addElementToTheBoard(7, 0, 8);
        sudokuBoard.addElementToTheBoard(7, 5, 1);
        sudokuBoard.addElementToTheBoard(7, 6, 6);
        sudokuBoard.addElementToTheBoard(7, 7, 5);

        sudokuBoard.addElementToTheBoard(8, 3, 7);
        sudokuBoard.addElementToTheBoard(8, 5, 3);
    }
}
