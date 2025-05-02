package com.ivatolm.sem6;

import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.stubs.SinCalculatorStub;

public class ModuleFactory {
    public enum Mode { REAL, STUB }

    public static Calculator createSin(Mode mode) {
        return (mode == Mode.REAL) ? new SinCalculator() : new SinCalculatorStub();
    }
}
