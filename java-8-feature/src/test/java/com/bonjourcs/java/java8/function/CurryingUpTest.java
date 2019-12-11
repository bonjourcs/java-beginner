package com.bonjourcs.java.java8.function;

import org.junit.Test;

import java.util.function.DoubleUnaryOperator;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/12/11
 */
public class CurryingUpTest {

    @Test
    public void testCurrying(){

        // CurryUp.curriedConvert(double a, double b) returns a function
        DoubleUnaryOperator convertCToF = CurryingUp.curriedConverter(9.0 / 5, 32);
        DoubleUnaryOperator convertUSDToGBP = CurryingUp.curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmToMi = CurryingUp.curriedConverter(0.6241, 0);

        double gpb = convertUSDToGBP.applyAsDouble(1000);
        double f = convertCToF.applyAsDouble(1000);
        double mi = convertKmToMi.applyAsDouble(1000);

    }
}
