package com.bonjourcs.java.ejc.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Liang Chenghao
 * Description: class for testing nio channel
 * Date: 2018/5/25
 */
public class FileChannelUtils {

    /**
     * write file using nio
     *
     * @param fileName file to write
     * @throws IOException io exception
     */
    public void writeFile(String fileName) throws IOException {

        ByteBuffer out = ByteBuffer.wrap("Hello \n".getBytes());
        ByteBuffer copy = ByteBuffer.allocate(12);

        // if file doesn't exist, create a new file
        Path filePath = Paths.get(NIOUtils.getClassPath(), fileName);
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }

        try (FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ, StandardOpenOption.WRITE)) {

            int nread;
            do {
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            fc.position(0);
            while (out.hasRemaining()) {
                fc.write(out);
            }
            out.rewind();

            long length = fc.size();
            fc.position(length - 1);
            copy.flip();
            while (copy.hasRemaining()) {
                fc.write(copy);
            }
            while (out.hasRemaining()) {
                fc.write(out);
            }

        }
    }
}
