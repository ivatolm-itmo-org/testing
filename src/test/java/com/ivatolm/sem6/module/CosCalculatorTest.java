package com.ivatolm.sem6.module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ivatolm.sem6.Calculator;
import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.SinCalculator;

public class CosCalculatorTest {
    private static final double EPSILON = 1e-6;
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new CosCalculator(new SinCalculator());
    }

    @ParameterizedTest
    @ValueSource(doubles = {
        0.0,
        Math.PI / 2,
        Math.PI,
        3 * Math.PI / 2,
        2 * Math.PI
    })
    public void testBoundaryValues(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 5, Math.PI / 6, Math.PI / 7})
    public void testSector1(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2 * Math.PI / 3, 3 * Math.PI / 4, 5 * Math.PI / 6})
    public void testSector2(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {4 * Math.PI / 3, 5 * Math.PI / 4, 7 * Math.PI / 6})
    public void testSector3(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {5 * Math.PI / 3, 7 * Math.PI / 4, 11 * Math.PI / 6})
    public void testSector4(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
        -Math.PI / 6,
        -Math.PI / 3,
        -2 * Math.PI / 3,
        -3 * Math.PI / 4,
        -5 * Math.PI / 6
    })
    public void testNegativeAngles(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
        5 * Math.PI,
        -3 * Math.PI,
        10 * Math.PI / 3,
        -7 * Math.PI / 4
    })
    public void testLargeAngles(double x) {
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @Test
    public void testSmallEpsilon() {
        double x = Math.PI / 4;
        double expected = Math.cos(x);
        assertEquals(expected, calculator.calc(x, 1e-10), 1e-10);
    }
}
