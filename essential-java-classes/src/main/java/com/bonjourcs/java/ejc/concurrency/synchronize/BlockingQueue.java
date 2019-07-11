package com.bonjourcs.java.ejc.concurrency.synchronize;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Liang Chenghao
 * Description: BlockingQueue class
 * Date: 2019/7/11
 */
public class BlockingQueue {

    private static final int FILE_QUEUE_SIZE = 10;

    private static final int SEARCH_THREADS = 100;

    private static final File DUMMY = new File("");

    private static final java.util.concurrent.BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String... args) {

        try (Scanner in = new Scanner(System.in)) {

            System.out.println("Enter a directory(e.g. /tmp/):");
            String directory = in.nextLine();
            System.out.println("Enter key word(e.g. foo):");
            String keyWord = in.nextLine();

            Runnable t = () -> {

                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            };

            new Thread(t).start();

            for (int i = 1; i <= SEARCH_THREADS; i++) {

                Runnable search = () -> {
                    try {
                        boolean done = false;
                        while (!done) {

                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyWord);
                            }
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                };

                new Thread(search).start();
            }
        }
    }

    private static void enumerate(File directory) throws InterruptedException {

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            } else {
                queue.put(file);
            }
        }

    }

    private static void search(File file, String word) throws IOException {

        try (Scanner in = new Scanner(file, "UTF-8")) {

            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(word)) {
                    System.out.printf("t-[%s] %s:%d:%s%n", Thread.currentThread().getName(), file.getPath(), lineNumber, word);
                }
            }
        }
    }
}
