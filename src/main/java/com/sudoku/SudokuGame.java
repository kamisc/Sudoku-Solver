package com.sudoku;

import java.util.ArrayList;
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

            menu.menu(sudokuBoard);

            System.out.println(sudokuBoard);

            /*sudokuBoard.getRow(1).addElement(1,5);
            sudokuBoard.getRow(8).addElement(4,9);
            sudokuBoard.getBoard().get(8).getElement(4).getPossibleValues().remove(4);

            System.out.println(sudokuBoard.getRow(8).getElement(4).getPossibleValues());*/
        }

    }

    public boolean resolveSudoku() {
        return false;
    }
}
