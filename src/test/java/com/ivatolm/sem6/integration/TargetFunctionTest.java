package com.ivatolm.sem6.integration;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ivatolm.sem6.ModuleFactory;
import com.ivatolm.sem6.functions.TargetFunction;

public class TargetFunctionTest {

    private static final double EPSILON = 1e-6;

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubs(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.STUB),
            ModuleFactory.createCos(ModuleFactory.Mode.STUB),
            ModuleFactory.createTan(ModuleFactory.Mode.STUB),
            ModuleFactory.createCot(ModuleFactory.Mode.STUB),
            ModuleFactory.createSec(ModuleFactory.Mode.STUB),
            ModuleFactory.createCsc(ModuleFactory.Mode.STUB));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubsExceptSin(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.REAL),
            ModuleFactory.createCos(ModuleFactory.Mode.STUB),
            ModuleFactory.createTan(ModuleFactory.Mode.STUB),
            ModuleFactory.createCot(ModuleFactory.Mode.STUB),
            ModuleFactory.createSec(ModuleFactory.Mode.STUB),
            ModuleFactory.createCsc(ModuleFactory.Mode.STUB));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubsExceptCos(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.STUB),
            ModuleFactory.createCos(ModuleFactory.Mode.REAL),
            ModuleFactory.createTan(ModuleFactory.Mode.STUB),
            ModuleFactory.createCot(ModuleFactory.Mode.STUB),
            ModuleFactory.createSec(ModuleFactory.Mode.STUB),
            ModuleFactory.createCsc(ModuleFactory.Mode.STUB));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubsExceptTan(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.STUB),
            ModuleFactory.createCos(ModuleFactory.Mode.STUB),
            ModuleFactory.createTan(ModuleFactory.Mode.REAL),
            ModuleFactory.createCot(ModuleFactory.Mode.STUB),
            ModuleFactory.createSec(ModuleFactory.Mode.STUB),
            ModuleFactory.createCsc(ModuleFactory.Mode.STUB));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubsExceptCot(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.STUB),
            ModuleFactory.createCos(ModuleFactory.Mode.STUB),
            ModuleFactory.createTan(ModuleFactory.Mode.STUB),
            ModuleFactory.createCot(ModuleFactory.Mode.REAL),
            ModuleFactory.createSec(ModuleFactory.Mode.STUB),
            ModuleFactory.createCsc(ModuleFactory.Mode.STUB));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubsExceptSec(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.STUB),
            ModuleFactory.createCos(ModuleFactory.Mode.STUB),
            ModuleFactory.createTan(ModuleFactory.Mode.STUB),
            ModuleFactory.createCot(ModuleFactory.Mode.STUB),
            ModuleFactory.createSec(ModuleFactory.Mode.REAL),
            ModuleFactory.createCsc(ModuleFactory.Mode.STUB));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testAllStubsExceptCsc(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.STUB),
            ModuleFactory.createCos(ModuleFactory.Mode.STUB),
            ModuleFactory.createTan(ModuleFactory.Mode.STUB),
            ModuleFactory.createCot(ModuleFactory.Mode.STUB),
            ModuleFactory.createSec(ModuleFactory.Mode.STUB),
            ModuleFactory.createCsc(ModuleFactory.Mode.REAL));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 6})
    public void testNoStubs(double x) {
        TargetFunction f = new TargetFunction(
            ModuleFactory.createSin(ModuleFactory.Mode.REAL),
            ModuleFactory.createCos(ModuleFactory.Mode.REAL),
            ModuleFactory.createTan(ModuleFactory.Mode.REAL),
            ModuleFactory.createCot(ModuleFactory.Mode.REAL),
            ModuleFactory.createSec(ModuleFactory.Mode.REAL),
            ModuleFactory.createCsc(ModuleFactory.Mode.REAL));

        double result = f.calc(x, EPSILON);
        System.out.println(result);
    }

}
