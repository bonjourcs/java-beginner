package com.bonjourcs.java.ejc.concurrency.thread;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/6
 */
public class CallbackInstanceMain {

    public static void main(String... args) {

        for (String arg : args) {
            CallbackInstanceInterface instanceInterface = new CallbackInstanceInterface(arg);
            instanceInterface.startThread();
        }

    }
}
