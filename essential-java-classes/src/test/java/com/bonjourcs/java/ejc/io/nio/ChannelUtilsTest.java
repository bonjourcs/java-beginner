package com.bonjourcs.java.ejc.io.nio;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/23
 */
public class ChannelUtilsTest {

    private ChannelUtils channelUtils;

    @Before
    public void init() {
        this.channelUtils = new ChannelUtils();
    }

    @Test
    public void testCopyFile() throws IOException {
//        channelUtils.copyFile("file_nio.txt", "file_nio_copy.txt");
//        channelUtils.readFile("file_nio_copy.txt");
    }

}
