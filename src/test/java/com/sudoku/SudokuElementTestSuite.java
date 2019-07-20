package com.sudoku;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author Kamil Seweryn
 */

public class SudokuElementTestSuite {

    @Test
    public void testCreateElementWithEmptyValue() {
        // Given
        SudokuElement sudokuElement = new SudokuElement(SudokuElement.EMPTY);

        // When
        int value = sudokuElement.getValue();

        // Then
        Assert.assertEquals(0,value);
    }

    @Test
    public void testCreateNewElement() {
        // Given
        SudokuElement sudokuElement = new SudokuElement(5);

        // When
        int value = sudokuElement.getValue();

        // Then
        Assert.assertEquals(5, value);
    }

    @Test
    public void testPossibleValuesList() {
        // Given
        SudokuElement sudokuElement = new SudokuElement(6);

        // When
        int size = sudokuElement.getPossibleValues().size();

        // Then
        Assert.assertEquals(9, size);
    }
}
