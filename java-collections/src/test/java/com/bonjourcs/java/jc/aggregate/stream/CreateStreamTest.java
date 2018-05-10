package com.bonjourcs.java.jc.aggregate.stream;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/10
 */
public class CreateStreamTest {

    @Test
    public void testShowStream() {
        CreateStream createStream = new CreateStream();
        createStream.showStream("show double stream",
                createStream.generateStream(), 10);
    }

}