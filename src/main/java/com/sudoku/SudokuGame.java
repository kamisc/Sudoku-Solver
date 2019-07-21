package com.sudoku;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class SudokuGame {

    public static void main(String[] args) {
        Menu menu = new Menu();
        SudokuBoard sudokuBoard = new SudokuBoard();

        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();

            System.out.println(sudokuBoard);

            menu.menu(sudokuBoard);

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
    }

    public boolean resolveSudoku() {
        return false;
    }
}
