package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description: SimpleLogger
 * Date: 2018/10/23
 */
public class SimpleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("SIMPLE LOGGER IS LOGGING: " + message);
    }

}
