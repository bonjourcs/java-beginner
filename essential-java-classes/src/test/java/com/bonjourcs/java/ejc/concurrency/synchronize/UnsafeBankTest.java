package com.bonjourcs.java.ejc.concurrency.synchronize;

import org.junit.Test;

import java.util.Random;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/7/1
 */
public class UnsafeBankTest {

    private final int BANK_COUNT = 10;

    private final int INIT_MONEY = 1000;

    private final int DEFAULT_TRANSFER = 500;

    private final int DELAY = 10;

    @Test
    public void testUnsafeBankTransferTest() throws InterruptedException {

        UnsafeBank bank = new UnsafeBank();
        bank.init(BANK_COUNT, INIT_MONEY);
        Random random = new Random();

        for (int i = 0; i < BANK_COUNT; i++) {

            int fromAccount = i;

            Runnable runnable = () -> {
                while (true) {
                    int toAccount = random.nextInt(BANK_COUNT);
//                    bank.transfer(fromAccount, toAccount, random.nextInt(DEFAULT_TRANSFER));
                    bank.safeTransferWithLock(fromAccount, toAccount, random.nextInt(DEFAULT_TRANSFER));
                    try {
                        Thread.sleep(random.nextInt(DELAY));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();

        }

        Thread.sleep(1000);

    }

}
