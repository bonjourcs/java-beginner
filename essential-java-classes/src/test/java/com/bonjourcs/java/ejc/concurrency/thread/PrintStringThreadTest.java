package com.bonjourcs.java.ejc.concurrency.thread;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/9/10
 */
public class PrintStringThreadTest {

    private String[] strings;

    @Before
    public void init() {
        strings = new String[]{"1", "2", "3", "4", "5"};
    }

    @Test
    public void test() {

        PrintStringThread t = new PrintStringThread(strings);
        new Thread(t).start();

    }
}