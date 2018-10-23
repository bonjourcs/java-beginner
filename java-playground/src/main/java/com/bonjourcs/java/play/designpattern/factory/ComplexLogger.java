package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description: ComplexLogger
 * Date: 2018/10/23
 */
public class ComplexLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("COMPLEX LOGGER IS LOGGING: " + message);
    }

}
