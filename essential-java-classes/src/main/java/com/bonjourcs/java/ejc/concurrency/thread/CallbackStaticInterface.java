package com.bonjourcs.java.ejc.concurrency.thread;

/**
 * @author Liang Chenghao
 * Description: callback static interface
 * Date: 2019/6/6
 */
public class CallbackStaticInterface {

    public static void displayInfo(String info, long time) {
        System.out.println(info + " takes " + time + "ms");
    }

}
