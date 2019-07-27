package com.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author Kamil Seweryn
 */

public class SudokuBoardTestSuite {
    private SudokuBoard sudokuBoard;

    @Before
    public void setUpBoard() {
        sudokuBoard = new SudokuBoard();
        sudokuBoard.addElementToTheBoard(0, 0, 5);
        sudokuBoard.addElementToTheBoard(0, 1, 3);
        sudokuBoard.addElementToTheBoard(0, 4, 7);
        sudokuBoard.addElementToTheBoard(1, 0, 6);
        sudokuBoard.addElementToTheBoard(1, 3, 1);
        sudokuBoard.addElementToTheBoard(1, 4, 9);
        sudokuBoard.addElementToTheBoard(1, 5, 5);
        sudokuBoard.addElementToTheBoard(2, 1, 9);
        sudokuBoard.addElementToTheBoard(2, 2, 8);
        sudokuBoard.addElementToTheBoard(2, 7, 6);
        sudokuBoard.addElementToTheBoard(3, 0, 8);
        sudokuBoard.addElementToTheBoard(3, 4, 6);
        sudokuBoard.addElementToTheBoard(3, 8, 3);
        sudokuBoard.addElementToTheBoard(4, 0, 4);
        sudokuBoard.addElementToTheBoard(4, 3, 8);
        sudokuBoard.addElementToTheBoard(4, 5, 3);
        sudokuBoard.addElementToTheBoard(4, 8, 1);
        sudokuBoard.addElementToTheBoard(5, 0, 7);
        sudokuBoard.addElementToTheBoard(5, 4, 2);
        sudokuBoard.addElementToTheBoard(5, 8, 6);
        sudokuBoard.addElementToTheBoard(6, 1, 6);
        sudokuBoard.addElementToTheBoard(6, 6, 2);
        sudokuBoard.addElementToTheBoard(6, 7, 8);
        sudokuBoard.addElementToTheBoard(7, 3, 4);
        sudokuBoard.addElementToTheBoard(7, 4, 1);
        sudokuBoard.addElementToTheBoard(7, 5, 9);
        sudokuBoard.addElementToTheBoard(7, 8, 5);
        sudokuBoard.addElementToTheBoard(8, 4, 8);
        sudokuBoard.addElementToTheBoard(8, 7, 7);
        sudokuBoard.addElementToTheBoard(8, 8, 9);
        //System.out.println(sudokuBoard);
    }

    @Test
    public void testCreateEmptyBoard() {
        // Given

        // When
        int size = sudokuBoard.getBoard().size();

        // Then
        Assert.assertEquals(9, size);
    }

    @Test
    public void testGetRow() {
        // Given

        // When
        int size = sudokuBoard.getRow(8).getRow().size();

        // Then
        Assert.assertEquals(9, size);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNotExistRow() {
        // Given

        // When
       sudokuBoard.getRow(9);
    }

    @Test
    public void testAddElementToTheBoard() {
        // Given

        // When
        sudokuBoard.addElementToTheBoard(5, 6,8);
        sudokuBoard.addElementToTheBoard(7, 7,9);
        sudokuBoard.addElementToTheBoard(1, 2,1);

        int value1 = sudokuBoard.getRow(5).getElement(6).getValue();
        int value2 = sudokuBoard.getRow(7).getElement(7).getValue();
        int value3 = sudokuBoard.getRow(1).getElement(2).getValue();

        // Then
        Assert.assertEquals(8, value1);
        Assert.assertEquals(9, value2);
        Assert.assertEquals(1, value3);
    }

    @Test
    public void testIsInRow() {
        // Given

        // When
        boolean isInRow1 = sudokuBoard.isInRow(0, 7);
        boolean isInRow2 = sudokuBoard.isInRow(8, 9);
        boolean isInRow3 = sudokuBoard.isInRow(4, 3);

        // Then
        Assert.assertTrue(isInRow1);
        Assert.assertTrue(isInRow2);
        Assert.assertTrue(isInRow3);
    }

    @Test
    public void testIsNotInRow() {
        // Given

        // When
        boolean isNotInRow1 = sudokuBoard.isInRow(3, 7);
        boolean isNotInRow2 = sudokuBoard.isInRow(0, 9);
        boolean isNotInRow3 = sudokuBoard.isInRow(8, 6);

        // Then
        Assert.assertFalse(isNotInRow1);
        Assert.assertFalse(isNotInRow2);
        Assert.assertFalse(isNotInRow3);
    }

    @Test
    public void testIsInColumn() {
        // Given

        // When
        boolean isInColumn1 = sudokuBoard.isInColumn(0, 4);
        boolean isInColumn2 = sudokuBoard.isInColumn(8, 6);
        boolean isInColumn3 = sudokuBoard.isInColumn(4, 2);

        // Then
        Assert.assertTrue(isInColumn1);
        Assert.assertTrue(isInColumn2);
        Assert.assertTrue(isInColumn3);
    }

    @Test
    public void testIsNotInColumn() {
        // Given

        // When
        boolean isNotInColumn1 = sudokuBoard.isInColumn(8, 4);
        boolean isNotInColumn2 = sudokuBoard.isInColumn(0, 1);
        boolean isNotInColumn3 = sudokuBoard.isInColumn(7, 5);

        // Then
        Assert.assertFalse(isNotInColumn1);
        Assert.assertFalse(isNotInColumn2);
        Assert.assertFalse(isNotInColumn3);
    }

    @Test
    public void testIsInBlock() {
        // Given

        // When
        boolean isInBlock1 = sudokuBoard.isInBlock(2, 2, 8);
        boolean isInBlock2 = sudokuBoard.isInBlock(3, 5, 8);
        boolean isInBlock3 = sudokuBoard.isInBlock(8, 7, 2);

        // Then
        Assert.assertTrue(isInBlock1);
        Assert.assertTrue(isInBlock2);
        Assert.assertTrue(isInBlock3);
    }

    @Test
    public void testIsNotInBlock() {
        // Given

        // When
        boolean isNotInBlock1 = sudokuBoard.isInBlock(2, 5, 6);
        boolean isNotInBlock2 = sudokuBoard.isInBlock(4, 8, 9);
        boolean isNotInBlock3 = sudokuBoard.isInBlock(2, 5, 6);

        // Then
        Assert.assertFalse(isNotInBlock1);
        Assert.assertFalse(isNotInBlock2);
        Assert.assertFalse(isNotInBlock3);
    }

    @Test
    public void testRemoveValueFromPossibleValuesInRow() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValuesInRow(0, 7);
        int size1 = sudokuBoard.getRow(0).getElement(0).getPossibleValues().size();
        int size2 = sudokuBoard.getRow(0).getElement(4).getPossibleValues().size();
        int size3 = sudokuBoard.getRow(0).getElement(8).getPossibleValues().size();

        // Then
        Assert.assertEquals(8,  size1);
        Assert.assertEquals(8,  size2);
        Assert.assertEquals(8,  size3);
    }

    @Test
    public void testRemoveValueFromPossibleValuesInColumn() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValuesInColumn(8, 9);
        int size1 = sudokuBoard.getRow(0).getElement(8).getPossibleValues().size();
        int size2 = sudokuBoard.getRow(8).getElement(8).getPossibleValues().size();
        int size3 = sudokuBoard.getRow(5).getElement(8).getPossibleValues().size();

        // Then
        Assert.assertEquals(8, size1);
        Assert.assertEquals(8, size2);
        Assert.assertEquals(8, size3);
    }

    @Test
    public void testRemoveValueFromPossibleValuesInBlock() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValuesInBlock(2, 5, 9);
        int size1 = sudokuBoard.getRow(0).getElement(3).getPossibleValues().size();
        int size2 = sudokuBoard.getRow(1).getElement(4).getPossibleValues().size();
        int size3 = sudokuBoard.getRow(2).getElement(5).getPossibleValues().size();

        // Then
        Assert.assertEquals(8, size1);
        Assert.assertEquals(8, size2);
        Assert.assertEquals(8, size3);
    }

    @Test
    public void testRemoveValueFromPossibleValues() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        int size1 = sudokuBoard.getRow(5).getElement(6).getPossibleValues().size();
        int size2 = sudokuBoard.getRow(8).getElement(6).getPossibleValues().size();
        int size3 = sudokuBoard.getRow(6).getElement(2).getPossibleValues().size();
        int size4 = sudokuBoard.getRow(4).getElement(4).getPossibleValues().size();
        int size5 = sudokuBoard.getRow(1).getElement(1).getPossibleValues().size();

        // Then
        Assert.assertEquals(4, size1);
        Assert.assertEquals(4, size2);
        Assert.assertEquals(6, size3);
        Assert.assertEquals(1, size4);
        Assert.assertEquals(3, size5);
    }

    @Test
    public void testIsInPossibleValuesRow() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        boolean isIn1 = sudokuBoard.isInPossibleValuesRow(0, 4);
        boolean isIn2 = sudokuBoard.isInPossibleValuesRow(4, 7);
        boolean isIn3 = sudokuBoard.isInPossibleValuesRow(8, 5);

        // Then
        Assert.assertTrue(isIn1);
        Assert.assertTrue(isIn2);
        Assert.assertTrue(isIn3);
    }

    @Test
    public void testIsNotInPossibleValuesRow() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        boolean isNotIn1 = sudokuBoard.isInPossibleValuesRow(2, 8);
        boolean isNotIn2 = sudokuBoard.isInPossibleValuesRow(5, 7);
        boolean isNotIn3 = sudokuBoard.isInPossibleValuesRow(7, 1);

        // Then
        Assert.assertFalse(isNotIn1);
        Assert.assertFalse(isNotIn2);
        Assert.assertFalse(isNotIn3);
    }

    @Test
    public void testIsInPossibleValuesColumn() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        boolean isIn1 = sudokuBoard.isInPossibleValuesColumn(0, 1);
        boolean isIn2 = sudokuBoard.isInPossibleValuesColumn(4, 5);
        boolean isIn3 = sudokuBoard.isInPossibleValuesColumn(7, 9);

        // Then
        Assert.assertTrue(isIn1);
        Assert.assertTrue(isIn2);
        Assert.assertTrue(isIn3);
    }

    @Test
    public void testIsNotInPossibleValuesColumn() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        boolean isNotIn1 = sudokuBoard.isInPossibleValuesColumn(2, 8);
        boolean isNotIn2 = sudokuBoard.isInPossibleValuesColumn(5, 9);
        boolean isNotIn3 = sudokuBoard.isInPossibleValuesColumn(8, 1);

        // Then
        Assert.assertFalse(isNotIn1);
        Assert.assertFalse(isNotIn2);
        Assert.assertFalse(isNotIn3);
    }

    @Test
    public void testIsInPossibleValuesBlock() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        boolean isIn1 = sudokuBoard.isInPossibleValuesBlock(2, 3, 6);
        boolean isIn2 = sudokuBoard.isInPossibleValuesBlock(6, 8, 1);
        boolean isIn3 = sudokuBoard.isInPossibleValuesBlock(7, 4, 2);

        // Then
        Assert.assertTrue(isIn1);
        Assert.assertTrue(isIn2);
        Assert.assertTrue(isIn3);
    }

    @Test
    public void testIsNotInPossibleValuesBlock() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        boolean isNotIn1 = sudokuBoard.isInPossibleValuesBlock(0, 0, 6);
        boolean isNotIn2 = sudokuBoard.isInPossibleValuesBlock(4, 4, 2);
        boolean isNotIn3 = sudokuBoard.isInPossibleValuesBlock(4, 7, 3);

        // Then
        Assert.assertFalse(isNotIn1);
        Assert.assertFalse(isNotIn2);
        Assert.assertFalse(isNotIn3);
    }

    @Test
    public void testAddElementIfIsTheOnlyOneInPossibleValue() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();
        sudokuBoard.addElementIfIsTheOnlyOneInPossibleValues();

        int value = sudokuBoard.getRow(4).getElement(4).getValue();

        // Then
        Assert.assertEquals(5, value);
    }

    @Test
    public void testCheckIsEmptyElement() {
        // Given

        // When
        boolean isEmptyElement = sudokuBoard.checkIsEmptyElement();

        // Then
        Assert.assertTrue(isEmptyElement);
    }

    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        // Given
        sudokuBoard.removeValueFromPossibleValues();
        SudokuBoard deepClonedSudokuBoard = null;
        try {
            deepClonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        // When
         int size = deepClonedSudokuBoard.getBoard().size();

        // Then
        Assert.assertEquals(9, size);
    }

    @Test
    public void testDeepCopyGetElement() throws CloneNotSupportedException {
        // Given
        sudokuBoard.removeValueFromPossibleValues();
        SudokuBoard deepClonedSudokuBoard = null;
        try {
            deepClonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        // When
        int value1 = deepClonedSudokuBoard.getRow(8).getElement(8).getValue();
        int value2 = deepClonedSudokuBoard.getRow(3).getElement(4).getValue();
        int value3 = deepClonedSudokuBoard.getRow(1).getElement(5).getValue();

        // Then
        Assert.assertEquals(9, value1);
        Assert.assertEquals(6, value2);
        Assert.assertEquals(5, value3);
    }

    @Test
    public void testDeepCopyGetPossibleValues() throws CloneNotSupportedException {
        // Given
        sudokuBoard.removeValueFromPossibleValues();
        SudokuBoard deepClonedSudokuBoard = null;
        try {
            deepClonedSudokuBoard = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        // When
        int value1 = deepClonedSudokuBoard.getRow(8).getElement(8).getPossibleValues().get(0);
        int value2 = deepClonedSudokuBoard.getRow(3).getElement(4).getPossibleValues().get(1);
        int value3 = deepClonedSudokuBoard.getRow(1).getElement(5).getPossibleValues().get(2);

        // Then
        Assert.assertEquals(4, value1);
        Assert.assertEquals(5, value2);
        Assert.assertEquals(8, value3);
    }

    @Test
    public void testFindFirstEmptyElement() {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        int row = sudokuBoard.findFirstEmptyElement().getEmptyRow();
        int col = sudokuBoard.findFirstEmptyElement().getEmptyColumn();

        // Then
        Assert.assertEquals(0, row);
        Assert.assertEquals(2, col);
    }

    @Test
    public void testGuessValue() throws CloneNotSupportedException {
        // Given

        // When
        sudokuBoard.removeValueFromPossibleValues();

        int startValue = sudokuBoard.getRow(0).getElement(2).getValue();
        int startSize = sudokuBoard.getRow(0).getElement(2).getPossibleValues().size();

        sudokuBoard.guessValue();

        sudokuBoard.removeValueFromPossibleValues();

        int valueAfterGuess = sudokuBoard.getRow(0).getElement(2).getValue();
        int sizeAfterGuess = sudokuBoard.getRow(0).getElement(2).getPossibleValues().size();

        // Then
        Assert.assertEquals(0, startValue);
        Assert.assertEquals(3, startSize);
        Assert.assertEquals(1, valueAfterGuess);
        Assert.assertEquals(2, sizeAfterGuess);
    }
}