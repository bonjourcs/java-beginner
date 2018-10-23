package com.bonjourcs.java.play.designpattern.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/10/23
 */
public class SimpleLoggerFactoryTest {

    @Test
    public void getLogger() {

        Logger logger = SimpleLoggerFactory.getLogger("simple");
        logger.log("something happened.");

        logger = SimpleLoggerFactory.getLogger("complex");
        logger.log("something happened.");

    }

}