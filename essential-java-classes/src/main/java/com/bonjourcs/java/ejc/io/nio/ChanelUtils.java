package com.bonjourcs.java.ejc.io.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * @author Liang Chenghao
 * Description:  use nio chanel
 * Date: 2018/5/22
 */
public class ChanelUtils {

    /**
     * copy file
     *
     * @param originalFile original file
     * @param targetFile   target file
     * @throws IOException exception
     */
    public void copyFile(String originalFile, String targetFile) throws IOException {

        Charset charset = StandardCharsets.UTF_8;

        Path originalPath = Paths.get(NIOUtils.getClassPath(), originalFile);
        Path targetPath = Paths.get(NIOUtils.getClassPath(), targetFile);

        BufferedReader reader = Files.newBufferedReader(originalPath, charset);
        BufferedWriter writer = Files.newBufferedWriter(targetPath, charset);

        // readLine will ignore line break
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    /**
     * read content from file
     *
     * @param fileName file to read
     * @throws IOException exception
     */
    public void readFile(String fileName) throws IOException {

        Path file = Paths.get(NIOUtils.getClassPath(), fileName);
        try (SeekableByteChannel sbc = Files.newByteChannel(file)) {

            ByteBuffer buffer = ByteBuffer.allocate(256);

            while (sbc.read(buffer) > 0) {
                buffer.rewind();
                System.out.println(StandardCharsets.UTF_8.decode(buffer));
                buffer.flip();
            }

        }

    }
}
