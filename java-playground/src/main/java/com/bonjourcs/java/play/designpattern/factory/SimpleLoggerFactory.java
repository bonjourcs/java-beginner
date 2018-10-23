package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/10/23
 */
public class SimpleLoggerFactory {

    public static Logger getLogger(String loggerName) {

        Logger logger = null;

        if ("simple".equals(loggerName)) {
            logger = new SimpleLogger();
        } else if ("complex".equals(loggerName)) {
            logger = new ComplexLogger();
        }

        return logger;

    }
}
