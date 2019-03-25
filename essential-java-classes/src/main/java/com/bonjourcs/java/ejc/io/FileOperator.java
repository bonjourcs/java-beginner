package com.bonjourcs.java.ejc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/3/6
 */
public class FileOperator {

    public static void main(String... args) throws FileNotFoundException {

        File file = new File("D:/tt.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

    }
}
