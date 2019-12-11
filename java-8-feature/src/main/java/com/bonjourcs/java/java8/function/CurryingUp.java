package com.bonjourcs.java.java8.function;

import java.util.function.DoubleUnaryOperator;

/**
 * @author Liang Chenghao
 * Description: currying functions
 * Date: 2019/12/11
 */
public class CurryingUp {

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

}
