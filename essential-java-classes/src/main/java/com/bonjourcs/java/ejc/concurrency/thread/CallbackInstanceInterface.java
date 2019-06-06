package com.bonjourcs.java.ejc.concurrency.thread;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/6
 */
public class CallbackInstanceInterface {

    private String threadName;

    public CallbackInstanceInterface(String threadName) {
        this.threadName = threadName;
    }

    public void displayInfo(String threadName, long time) {
        System.out.println(threadName + " spend: " + time + " ms");
    }

    public void startThread(){
        CallbackInstanceThread thread = new CallbackInstanceThread(threadName, this);
        new Thread(thread).start();
    }

}
