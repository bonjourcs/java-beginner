package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/10/23
 */
public class SLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("SLOGGER IS LOGGING: " + message);
    }

}
