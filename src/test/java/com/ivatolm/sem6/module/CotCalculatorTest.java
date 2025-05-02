package com.ivatolm.sem6.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ivatolm.sem6.Calculator;
import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.CotCalculator;
import com.ivatolm.sem6.functions.SinCalculator;

public class CotCalculatorTest {
    private static final double EPSILON = 1e-6;
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        SinCalculator sinCalculator = new SinCalculator();
        CosCalculator cosCalculator = new CosCalculator(sinCalculator);
        calculator = new CotCalculator(sinCalculator, cosCalculator);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 4, Math.PI / 3, Math.PI / 6})
    public void testBoundaryValues(double x) {
        double expected = 1 / Math.tan(x);
        assertEquals(expected, calculator.calc(x, EPSILON), EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, Math.PI, 2 * Math.PI})
    public void testDiscontinuityPoints(double x) {
        assertThrows(ArithmeticException.class, () -> calculator.calc(x, EPSILON));
    }

    @Test
    public void testSmallEpsilon() {
        double x = Math.PI / 6;
        assertEquals(Math.sqrt(3), calculator.calc(x, 1e-10), 1e-10);
    }
}
