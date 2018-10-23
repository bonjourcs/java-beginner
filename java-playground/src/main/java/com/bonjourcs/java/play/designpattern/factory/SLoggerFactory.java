package com.bonjourcs.java.play.designpattern.factory;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/10/23
 */
public class SLoggerFactory implements LoggerFactory {

    @Override
    public Logger getLogger() {
        return new SLogger();
    }

}
