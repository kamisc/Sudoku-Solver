package com.sudoku;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author Kamil Seweryn
 */

public class SudokuRowTestSuite {

    @Test
    public void testCreateEmptyRow() {
        // Given
        SudokuRow sudokuRow = new SudokuRow();

        // When
        int size = sudokuRow.getRow().size();

        // Then
        Assert.assertEquals(9, size);
    }

    @Test
    public void testGetElement() {
        // Given
        SudokuRow sudokuRow = new SudokuRow();

        // When
        sudokuRow.addElement(8, 3);

        int value1 = sudokuRow.getElement(8).getValue();
        int value2 = sudokuRow.getElement(4).getValue();

        // Then
        Assert.assertEquals(3, value1);
        Assert.assertEquals(0, value2);
    }

    @Test
    public void testAddElementToRow() {
        // Given
        SudokuRow sudokuRow = new SudokuRow();

        // When
        sudokuRow.addElement(5,6);
        sudokuRow.addElement(3,7);
        sudokuRow.addElement(1,1);

        int value1 = sudokuRow.getElement(5).getValue();
        int value2 = sudokuRow.getElement(3).getValue();
        int value3 = sudokuRow.getElement(1).getValue();

        // Then
        Assert.assertEquals(6, value1);
        Assert.assertEquals(7, value2);
        Assert.assertEquals(1, value3);
    }
}