package com.bonjourcs.java.java8.function;

import java.util.function.Function;

/**
 * @author Liang Chenghao
 * Description: function compose class
 * Date: 2019/4/26
 */
public class FunctionCompose {

    public static <T, R, S> Function<T, S> andCompose(Function<T, R> f1, Function<R, S> f2) {
        return f1.andThen(f2);
    }

    public static <T, R, S> Function<T, S> compose(Function<R, S> f1, Function<T, R> f2) {
        return f1.compose(f2);
    }

}
