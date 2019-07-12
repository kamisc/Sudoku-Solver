package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class SudokuGame {

    public static void main(String[] args) {
        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }

        SudokuBoard sudokuBoard = new SudokuBoard();
        System.out.println(sudokuBoard);

        Menu.menu();

    }

    public boolean resolveSudoku() {
        return true;
    }
}
