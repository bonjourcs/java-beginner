package com.bonjourcs.java.play.designpattern.factory;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/10/23
 */
public class LoggerFactoryTest {


    @Test
    public void testGetLogger() {

        // a SLoggerFactory is created
        LoggerFactory loggerFactory = new SLoggerFactory();
        Logger logger = loggerFactory.getLogger();
        logger.log("hi, there.");

        // a MLoggerFactory is created
        loggerFactory = new MLoggerFactory();
        logger = loggerFactory.getLogger();
        logger.log("hi, there.");

    }
}