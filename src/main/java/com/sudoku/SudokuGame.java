package com.sudoku;

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

            sudokuBoard.getRow(0).addElement(1, 1);
            sudokuBoard.getRow(0).addElement(3, 2);
            sudokuBoard.getRow(0).addElement(8, 3);
            sudokuBoard.getRow(0).addElement(7, 4);
            System.out.println(sudokuBoard.getRow(0));
            System.out.println(sudokuBoard.getRow(0).getRow().size());
        }
    }

    public boolean resolveSudoku() {
        return false;
    }
}
