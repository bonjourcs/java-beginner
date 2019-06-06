package com.bonjourcs.java.ejc.concurrency.thread;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/6
 */
public class CallbackStaticInterfaceMain {

    public static void main(String... args) {

        for (String arg: args){
            Thread thread = new Thread(new CallbackStaticInterfaceThread(arg));
            thread.start();
        }

    }

}
