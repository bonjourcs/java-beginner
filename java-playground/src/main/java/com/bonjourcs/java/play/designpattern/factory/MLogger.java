package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description: MLogger
 * Date: 2018/10/23
 */
public class MLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("MLOGGER IS LOGGING: " + message);
    }

}
