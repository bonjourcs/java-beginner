package com.bonjourcs.java.ejc.io.nio;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/21
 */
public class FileUtilsTest {

    @Test
    public void testCopyFile() throws IOException {
        FileUtils.copyFile("file_original.txt", "file_original_copy.txt");
    }

    @Test
    public void testMoveFile() throws IOException {
        // rename file
        FileUtils.moveFile("file_original.txt", "file_original_move.txt");
        // rename back
        FileUtils.moveFile("file_original_move.txt", "file_original.txt");
    }

    @Test
    public void testGetBasicAttributes() throws IOException {
        FileUtils.getBasicAttribute("file_attribute.txt");
    }

    @Test
    public void testCreateTempFile() throws IOException {
        Path file = FileUtils.createTempFile(".tmp");
        System.out.printf("File %s created!", file);
    }

    @Test
    public void testCreateLink() throws IOException {
        Path link = FileUtils.createHardLink("file_nio.txt", "file_nio.link");
        Assert.assertFalse(Files.isSymbolicLink(link));
    }

    @Test
    public void testCreateSymbolLink() throws IOException {
        Path link = FileUtils.createSymbolicLink("file_nio.txt", "file_nio.soft");
        Assert.assertTrue(Files.isSymbolicLink(link));
    }

}