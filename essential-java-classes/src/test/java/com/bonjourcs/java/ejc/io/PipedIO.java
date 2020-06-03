package com.bonjourcs.java.ejc.io;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Liang Chenghao
 * Description:  pipe io test
 * Date: 2020/6/3
 */
public class PipedIO {

    @Test
    public void testPipedIO() throws IOException, InterruptedException {

        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        Thread threadOut = new Thread(() -> {
            try {
                out.write("Hello, pipe!".getBytes());
                // avoid write dead end exception
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread threadIn = new Thread(() -> {
            int data;
            try {
                while ((data = in.read()) != -1) {
                    System.out.print((char) data);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        threadOut.start();
        threadIn.start();

        // see output result
        threadOut.join();
        threadIn.join();

    }

}
