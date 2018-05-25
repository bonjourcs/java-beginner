package com.bonjourcs.java.ejc.io.nio;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/25
 */
public class FileChannelUtilsTest {

    private FileChannelUtils fileChannelUtils;

    @Before
    public void init() {
        fileChannelUtils = new FileChannelUtils();
    }

    @Test
    public void testWriteFile() throws IOException {
        fileChannelUtils.writeFile("chanel_file.txt");
    }

}