package com.bonjourcs.java.ejc.concurrency.thread;

/**
 * @author Liang Chenghao
 * Description: a simple thread class
 * Date: 2018/8/3
 */
public class HelloThread implements Runnable {

    @Override
    public void run() {
        System.out.println("[HelloThread] running...");
    }

}
