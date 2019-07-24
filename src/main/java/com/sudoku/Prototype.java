package com.sudoku;

/**
 * Author Kamil Seweryn
 */

public class Prototype<T> implements Cloneable {
    @Override
    public T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}
