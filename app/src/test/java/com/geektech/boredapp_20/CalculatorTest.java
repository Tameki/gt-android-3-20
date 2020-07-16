package com.geektech.boredapp_20;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void addition_isCorrect() {
        assertEquals(
                6,
                calculator.sum(4, 2)
        );
    }

    @Test
    public void addition_isNullPointerSafe() {
        assertEquals(
                -1,
                calculator.sum(4, null)
        );
    }
}