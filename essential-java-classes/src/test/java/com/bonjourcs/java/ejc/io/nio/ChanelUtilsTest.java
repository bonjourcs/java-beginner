package com.bonjourcs.java.ejc.io.nio;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/23
 */
public class ChanelUtilsTest {

    private ChanelUtils chanelUtils;

    @Before
    public void init() {
        this.chanelUtils = new ChanelUtils();
    }

    @Test
    public void testCopyFile() throws IOException {
        chanelUtils.copyFile("file_nio.txt", "file_nio_copy.txt");
        chanelUtils.readFile("file_nio_copy.txt");
    }

}