package com.sudoku;

import java.util.Scanner;

/**
 * Author Kamil Seweryn
 */

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private int choice;

    public void menu(SudokuBoard sudokuBoard) {
        System.out.println("What do you want to do?\n" +
                "1. Set new number to board\n" +
                "2. Solve Sudoku\n" +
                "3. End game" +
                "\n\nRemeber to confirm all operations by click the ENTER!");

        try {
            choice = sc.nextInt();
            if(choice < 1 || choice > 3) {
                throw new WrongChoice();
            }
        } catch (WrongChoice e) {
            System.out.println(e.getMessage() + "You must pick 1, 2 or 3!");
        }

        switch (choice) {
            case 1:
                System.out.println("Set number to the board - X, Y, VALUE. After get number computer display the board.");

                System.out.println("Set X - column: ");
                int col = sc.nextInt() - 1;

                System.out.println("Set Y - row: ");
                int row = sc.nextInt() - 1;

                System.out.println("Set VALUE: ");
                int value = sc.nextInt();

                sudokuBoard.addElementToTheBoard(row, col, value);
                break;

            case 2:
                break;

            case 3:
                System.exit(0);
                break;
        }
    }

    // Metoda wpisująca

}
