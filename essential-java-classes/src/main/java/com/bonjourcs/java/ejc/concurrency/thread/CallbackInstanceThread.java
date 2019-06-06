package com.bonjourcs.java.ejc.concurrency.thread;

import java.util.Random;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/6
 */
public class CallbackInstanceThread implements Runnable {

    private String threadName;

    private CallbackInstanceInterface callbackInstanceInterface;

    public CallbackInstanceThread(String threadName, CallbackInstanceInterface callbackInstanceInterface) {
        this.threadName = threadName;
        this.callbackInstanceInterface = callbackInstanceInterface;
    }

    @Override
    public void run() {

        long time = new Random().nextInt(1000);
        try {
            Thread.sleep(time);
            callbackInstanceInterface.displayInfo(threadName, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
