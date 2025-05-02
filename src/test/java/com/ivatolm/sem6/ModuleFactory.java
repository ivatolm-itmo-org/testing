package com.ivatolm.sem6;

import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.CotCalculator;
import com.ivatolm.sem6.functions.CscCalculator;
import com.ivatolm.sem6.functions.SecCalculator;
import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.TanCalculator;
import com.ivatolm.sem6.stubs.CosCalculatorStub;
import com.ivatolm.sem6.stubs.CotCalculatorStub;
import com.ivatolm.sem6.stubs.CscCalculatorStub;
import com.ivatolm.sem6.stubs.SecCalculatorStub;
import com.ivatolm.sem6.stubs.SinCalculatorStub;
import com.ivatolm.sem6.stubs.TanCalculatorStub;

public class ModuleFactory {
    public enum Mode { REAL, STUB }

    public static Calculator createSin(Mode mode) {
        return (mode == Mode.REAL) ? new SinCalculator() : new SinCalculatorStub();
    }

    public static Calculator createCos(Mode mode) {
        return (mode == Mode.REAL) ? new CosCalculator(new SinCalculator()) : new CosCalculatorStub();
    }

    public static Calculator createTan(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        return (mode == Mode.REAL) ? new TanCalculator(sinCalc, new CosCalculator(sinCalc)) : new TanCalculatorStub();
    }

    public static Calculator createCot(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        return (mode == Mode.REAL) ? new CotCalculator(sinCalc, new CosCalculator(sinCalc)) : new CotCalculatorStub();
    }

    public static Calculator createSec(Mode mode) {
        CosCalculator cosCalc = new CosCalculator(new SinCalculator());
        return (mode == Mode.REAL) ? new SecCalculator(cosCalc) : new SecCalculatorStub();
    }

    public static Calculator createCsc(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        return (mode == Mode.REAL) ? new CscCalculator(sinCalc) : new CscCalculatorStub();
    }
}
