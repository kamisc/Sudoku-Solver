package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class UnsolvableException extends Exception {
    public UnsolvableException() {
        super("This Sudoku is UNSOLVABLE!!!");
    }
}
