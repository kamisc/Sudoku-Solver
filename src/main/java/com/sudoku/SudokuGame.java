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
        }
    }

    public boolean resolveSudoku() {
        return false;
    }
}
