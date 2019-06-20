package com.bonjourcs.java.ejc.concurrency.thread;

import org.junit.Test;

import java.util.Random;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/8/3
 */
public class HelloThreadTest {

    @Test
    public void testHelloThread() throws InterruptedException {

        HelloThread t = new HelloThread();
        new Thread(t).start();
        Thread.sleep(1000);
        System.out.println("Main thread is running...");


    }

    @Test
    public void testGenerateRandom() {

        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(10000));
        }
    }

}
