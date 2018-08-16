package com.bonjourcs.java.play.common;

/**
 * @author Liang Chenghao
 * Description: check code generator for PRC ID card
 * Date: 2018/8/15
 */
public class IdCheckCodeGenerator {


    private static final int[] FLAG_NUMBERS = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    private static final String[] CHECK_CODES = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    /**
     * generate check code from 17-bit id number
     *
     * @param originCode id number
     * @return id number with check code
     */
    public static String generateCheckCode(String originCode) {

        if (originCode == null) {
            return null;
        }

        int len = originCode.length();
        if (len != FLAG_NUMBERS.length) {
            return null;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += charToInt(originCode.charAt(i)) * FLAG_NUMBERS[i];
        }

        return originCode + CHECK_CODES[(sum % 11)];
    }

    /**
     * char to int
     *
     * @param ch char to convert
     * @return int value
     */
    private static int charToInt(char ch) {
        return ch + (0 - '0');
    }

}
