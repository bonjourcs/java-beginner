package com.bonjourcs.java.ejc.concurrency.thread;

import java.util.Arrays;

/**
 * @author Liang Chenghao
 * Description: test thread sleep
 * Date: 2018/9/10
 */
public class PrintStringThread implements Runnable {

    private String[] args;

    public PrintStringThread(String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        Arrays.stream(args).forEach(
                e -> {
                    try {
                        Thread.sleep(5000);
                        System.out.println(e);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
        );
    }

    public static void main(String[] args) throws InterruptedException {

        String[] strings = {"1", "2", "3", "4", "5"};

        for (String string : strings) {
            Thread.sleep(5000);
            System.out.println(string);
        }

    }

}
