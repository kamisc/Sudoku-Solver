package com.sudoku;

import java.util.Scanner;

/**
 * Author Kamil Seweryn
 */

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private int choice;

    public void menu(SudokuBoard sudokuBoard) throws CloneNotSupportedException {
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
            System.out.println(e.getMessage() + "You must pick 1, 2 or 3!\n");
        }

        switch (choice) {
            case 1:
                System.out.println("Set number to the board - X, Y, VALUE. After get number computer display the board.");

                System.out.println("Set X - column: ");
                int col = setNumber() - 1;

                System.out.println("Set Y - row: ");
                int row = setNumber() - 1;

                System.out.println("Set VALUE: ");
                int value = setNumber();

                sudokuBoard.addElementToTheBoard(row, col, value);
                break;
            case 2:
                System.out.println("Start solving your SUDOKU...\n");
                while (sudokuBoard.checkIsEmptyElement()) {
                    sudokuBoard.solveSudoku();
                }
                if(!sudokuBoard.checkIsEmptyElement()) {
                    System.out.println("You solved the SUDOKU!\n");
                    System.out.println(sudokuBoard.toString());
                    System.exit(0);
                }
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private int setNumber() {
        boolean isValid = false;

        while (!isValid) {
            try {
                choice = sc.nextInt();
                if(choice < 1 || choice > 9) {
                    throw new WrongChoice();
                } else {
                    isValid = true;
                }
            } catch (WrongChoice e) {
                System.out.println(e.getMessage() + "You must write number between 1 to 9.");
            }
        }
        return choice;
    }
}
