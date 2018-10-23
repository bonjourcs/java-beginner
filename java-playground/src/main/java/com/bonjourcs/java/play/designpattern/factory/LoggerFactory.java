package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description: LoggerFactory
 * Date: 2018/10/23
 */
public interface LoggerFactory {

    /**
     * get a logger instance
     *
     * @return logger instance
     */
    Logger getLogger();

}
