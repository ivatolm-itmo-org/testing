package com.ivatolm.sem6.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ivatolm.sem6.Calculator;
import com.ivatolm.sem6.functions.CscCalculator;
import com.ivatolm.sem6.functions.SinCalculator;

public class CscCalculatorTest {
    private static final double EPSILON = 1e-6;
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new CscCalculator(new SinCalculator());
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 2, Math.PI / 6, 5 * Math.PI / 6})
    public void testBoundaryValues(double x) {
        double expected = 1 / Math.sin(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, Math.PI, 2 * Math.PI})
    public void testDiscontinuityPoints(double x) {
        assertThrows(ArithmeticException.class, () -> calculator.calc(x, EPSILON));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI / 6, -Math.PI / 2})
    public void testNegativeAngles(double x) {
        double expected = 1 / Math.sin(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @Test
    public void testHighPrecision() {
        double x = Math.PI / 4;
        double expected = Math.sqrt(2);
        assertEquals(expected, calculator.calc(x, 1e-10), 1e-10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
        Math.PI / 2 + 2 * Math.PI,
        Math.PI / 2 - 4 * Math.PI,
        3 * Math.PI / 2 + 6 * Math.PI
    })
    public void testPeriodicity(double x) {
        double expected = 1 / Math.sin(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }
}
