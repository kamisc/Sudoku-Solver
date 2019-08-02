package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class SudokuGame {

    public static void main(String[] args) throws CloneNotSupportedException {
        Menu menu = new Menu();
        SudokuBoard sudokuBoard = new SudokuBoard();

        sudokuBoard.createBoard();

        while(sudokuBoard.checkIsEmptyElement()) {
            System.out.println(sudokuBoard);

            menu.menu(sudokuBoard);
        }
    }
}
