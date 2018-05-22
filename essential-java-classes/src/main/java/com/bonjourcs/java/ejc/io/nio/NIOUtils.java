package com.bonjourcs.java.ejc.io.nio;

/**
 * @author Liang Chenghao
 * Description: NIO util class
 * Date: 2018/5/22
 */
public class NIOUtils {

    /**
     * Windows prefix
     */
    private static final String WINDOWS_PREFIX = "Windows";

    /**
     * get default classpath
     *
     * @return classpath uri
     */
    public static String getClassPath() {
        String os = System.getProperty("os.name");
        if (os.startsWith(WINDOWS_PREFIX)) {
            return ClassLoader
                    .getSystemResource("").getPath()
                    .replaceFirst("/", "");
        } else {
            return ClassLoader
                    .getSystemResource("").getPath();
        }
    }

}
