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

    public static SinCalculator createSin(Mode mode) {
        return (mode == Mode.REAL) ? new SinCalculator() : new SinCalculatorStub();
    }

    public static CosCalculator createCos(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        return (mode == Mode.REAL) ? new CosCalculator(sinCalc) : new CosCalculatorStub(sinCalc);
    }

    public static TanCalculator createTan(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        CosCalculator cosCalc = new CosCalculator(sinCalc);
        return (mode == Mode.REAL) ? new TanCalculator(sinCalc, cosCalc) : new TanCalculatorStub(sinCalc, cosCalc);
    }

    public static CotCalculator createCot(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        CosCalculator cosCalc = new CosCalculator(sinCalc);
        return (mode == Mode.REAL) ? new CotCalculator(sinCalc, cosCalc) : new CotCalculatorStub(sinCalc, cosCalc);
    }

    public static SecCalculator createSec(Mode mode) {
        CosCalculator cosCalc = new CosCalculator(new SinCalculator());
        return (mode == Mode.REAL) ? new SecCalculator(cosCalc) : new SecCalculatorStub(cosCalc);
    }

    public static CscCalculator createCsc(Mode mode) {
        SinCalculator sinCalc = new SinCalculator();
        return (mode == Mode.REAL) ? new CscCalculator(sinCalc) : new CscCalculatorStub(sinCalc);
    }
}
