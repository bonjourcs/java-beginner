package com.bonjourcs.java.ejc.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author Liang Chenghao
 * Description: uitl tools to file
 * Date: 2018/5/21
 */
public class FileUtils {

    /**
     * classpath
     */
    private static String CLASS_PATH;

    // get classpath
    static {
        CLASS_PATH = NIOUtils.getClassPath();
    }

    /**
     * copy file
     *
     * @param originalFile original file
     * @param targetFile   target file
     * @throws IOException exception
     */
    public static void copyFile(String originalFile, String targetFile) throws IOException {

        Path originalPath = Paths.get(CLASS_PATH, originalFile);
        Path targetPath = Paths.get(CLASS_PATH, targetFile);

        Files.copy(originalPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * move file
     *
     * @param originalFile original file
     * @param targetFile   target file
     * @throws IOException exception
     */
    public static void moveFile(String originalFile, String targetFile) throws IOException {

        Path originalPath = Paths.get(CLASS_PATH, originalFile);
        Path targetPath = Paths.get(CLASS_PATH, targetFile);

        Files.move(originalPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * get basic file attributes
     *
     * @param fileName file to read attributes
     * @throws IOException exception
     */
    public static void getBasicAttribute(String fileName) throws IOException {
        Path path = Paths.get(CLASS_PATH, fileName);
        if (Files.exists(path)) {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.printf("Create time : %s %n", attributes.creationTime());
            System.out.printf("Last access time: %s %n", attributes.lastAccessTime());
            FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
            Files.setLastModifiedTime(path, fileTime);
            System.out.printf("Last access time: %s %n", attributes.lastAccessTime());
        } else {
            System.out.println("File " + path + " doesn't exist.");
        }
    }

    /**
     * create temp file
     *
     * @return file created
     * @throws IOException exception
     */
    public static Path createTempFile(String suffix) throws IOException {
        return Files.createTempFile(null, suffix);
    }

    /**
     * create link
     *
     * @param fileName original file name
     * @param linkName target link name
     * @return created link
     * @throws IOException exception
     */
    public static Path createHardLink(String fileName, String linkName) throws IOException {
        Path filePath = Paths.get(NIOUtils.getClassPath(), fileName);
        Path linkPath = Paths.get(NIOUtils.getClassPath(), linkName);
        if (Files.exists(linkPath)) {
            Files.delete(linkPath);
        }
        return Files.createLink(linkPath, filePath);
    }

    /**
     * create symbol link
     *
     * @param fileName original file name
     * @param linkName target link name
     * @return link created
     * @throws IOException exception
     */
    public static Path createSymbolicLink(String fileName, String linkName) throws IOException {
        Path filePath = Paths.get(NIOUtils.getClassPath(), fileName);
        Path linkPath = Paths.get(NIOUtils.getClassPath(), linkName);
        if (Files.exists(linkPath)) {
            Files.delete(linkPath);
        }
        return Files.createSymbolicLink(linkPath, filePath);
    }

}
