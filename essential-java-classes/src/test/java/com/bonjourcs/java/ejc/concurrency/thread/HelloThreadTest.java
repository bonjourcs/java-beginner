package com.bonjourcs.java.ejc.concurrency.thread;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/8/3
 */
public class HelloThreadTest {

    @Test
    public void testHelloThread() {

        HelloThread t = new HelloThread();
        new Thread(t).start();

    }
}