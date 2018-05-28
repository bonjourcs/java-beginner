package com.bonjourcs.java.ejc.io.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/28
 */
public class BasicFinder extends SimpleFileVisitor<Path> {


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (attrs.isSymbolicLink()) {
            System.out.printf("Symbol link %s %n", file);
        } else if (attrs.isRegularFile()) {
            System.out.printf("Regular file %s %n", file);
        } else {
            System.out.printf("Other file %s %n", file);
        }

        System.out.println("(" + attrs.size() + ") bytes");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("Error %s occurs %n", exc);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.printf("Directory %s %n", dir);
        return FileVisitResult.CONTINUE;
    }

}
