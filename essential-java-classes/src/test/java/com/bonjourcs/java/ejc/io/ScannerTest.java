package com.bonjourcs.java.ejc.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/10/15
 */
public class ScannerTest {

    String path = ClassLoader.getSystemResource("").getPath();

    @Test
    public void testScanner() throws FileNotFoundException {

        String file = "scanner_test.ini";
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            path = path.replaceFirst("/", "");
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(path + file)))) {
            scanner.useDelimiter("\\*\\$");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }

    }

}
