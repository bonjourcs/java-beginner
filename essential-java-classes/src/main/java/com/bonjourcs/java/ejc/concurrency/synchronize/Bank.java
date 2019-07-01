package com.bonjourcs.java.ejc.concurrency.synchronize;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Liang Chenghao
 * Description: unsafe bank
 * Date: 2019/7/1
 */
public class Bank {

    private int[] accounts;

    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank() {
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }


    public void init(int accountNum, int initMoney) {
        accounts = new int[accountNum];
        Arrays.fill(accounts, initMoney);
    }

    public void transfer(int from, int to, int amount) throws InterruptedException {

        while (accounts[from] < amount) {
            sufficientFunds.await();
        }

        System.out.print(Thread.currentThread() + " ");
        accounts[from] -= amount;
        System.out.printf("Account[%d] transfer [%d] to account[%d].", from, amount, to);
        accounts[to] += amount;
        System.out.printf(" Bank balance: %d", getBalance());
        System.out.println();

        sufficientFunds.signalAll();

    }

    public void safeTransferWithLock(int form, int to, int amount) throws InterruptedException {

        bankLock.lock();
        try {
            transfer(form, to, amount);
        } finally {
            bankLock.unlock();
        }

    }


    public int getBalance() {

        bankLock.lock();
        try {
            int sum = 0;
            for (int a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }

    }
}

