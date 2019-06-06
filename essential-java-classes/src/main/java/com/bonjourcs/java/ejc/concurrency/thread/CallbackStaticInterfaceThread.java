package com.bonjourcs.java.ejc.concurrency.thread;

import java.util.Random;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/6
 */
public class CallbackStaticInterfaceThread implements Runnable {

    private String threadName;

    public CallbackStaticInterfaceThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {


        // sleep for random time
        try {
            long sleepTime = new Random().nextInt(10000) & Integer.MAX_VALUE;
            Thread.sleep(sleepTime);
            CallbackStaticInterface.displayInfo(threadName, sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
