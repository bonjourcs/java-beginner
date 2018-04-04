package com.bonjourcs.java.ejc.exception;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/4
 */
public class TryWithResourceTest {

    @Test
    public void testReadFile() {

        try {
            TryWithResource.readFile("out_file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}