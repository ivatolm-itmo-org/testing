package com.ivatolm.sem6.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ivatolm.sem6.Calculator;
import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.TanCalculator;

public class TanCalculatorTest {
    private static final double EPSILON = 1e-6;
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        SinCalculator sinCalculator = new SinCalculator();
        CosCalculator cosCalculator = new CosCalculator(sinCalculator);
        calculator = new TanCalculator(sinCalculator, cosCalculator);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
        0.0,
        Math.PI / 4,
        Math.PI,
        3 * Math.PI / 4
    })
    public void testBoundaryValues(double x) {
        double expected = Math.tan(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6, Math.PI / 4, Math.PI / 3})
    public void testOddFunction(double x) {
        double expected = calculator.calc(x, EPSILON);
        double actualNegative = calculator.calc(-x, EPSILON);
        assertEquals(-expected, actualNegative, EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6, Math.PI / 4, Math.PI / 3})
    public void testPeriodicity(double x) {
        double expected = calculator.calc(x, EPSILON);
        double actualPeriodic = calculator.calc(x + Math.PI, EPSILON);
        assertEquals(expected, actualPeriodic, 1e-5);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testSector1(double x) {
        assertTrue(calculator.calc(x, EPSILON) > 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2 * Math.PI / 3})
    public void testSector2(double x) {
        assertTrue(calculator.calc(x, EPSILON) < 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {4 * Math.PI / 3})
    public void testSector3(double x) {
        assertTrue(calculator.calc(x, EPSILON) > 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {5 * Math.PI / 3})
    public void testSector4(double x) {
        assertTrue(calculator.calc(x, EPSILON) < 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
        Math.PI / 2,
        3 * Math.PI / 2
    })
    public void testDiscontinuityPoints(double x) {
        assertThrows(ArithmeticException.class, () -> calculator.calc(x, EPSILON));
    }

    @Test
    public void testSmallEpsilon() {
        double x = Math.PI / 6;
        double expected = 1 / Math.sqrt(3);
        assertEquals(expected, calculator.calc(x, 1e-10), 1e-10);
    }
}
