package com.bonjourcs.java.ejc.io.nio;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/21
 */
public class PathUtilsTest {

    private PathUtils pathUtils;

    @Before
    public void init() {
        this.pathUtils = new PathUtils();
    }

    @Test
    public void testGetAPath() {
        pathUtils.getAPath();
    }

    @Test
    public void testRetrieveInfoFromPath() {
        pathUtils.retrieveInfoFromPath();
    }

    @Test
    public void testRedundancyPath() {
        pathUtils.redundancyPath();
    }

    @Test
    public void testIteratePath() {
        pathUtils.iteratePath();
    }

    @Test
    public void testGetDirectories() throws IOException {
        Path homeDir = Paths.get(System.getProperty("user.dir"));
        Files.newDirectoryStream(homeDir).forEach(e -> System.out.println(e.getFileName()));
    }
}