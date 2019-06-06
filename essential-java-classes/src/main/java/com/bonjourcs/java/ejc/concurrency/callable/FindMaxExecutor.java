package com.bonjourcs.java.ejc.concurrency.callable;

import com.bonjourcs.java.ejc.exception.ServiceException;

import java.util.concurrent.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/6/6
 */
public class FindMaxExecutor {

    public static int findMax(int[] array) throws ExecutionException, InterruptedException {

        if (array.length == 1) {
            return array[0];
        } else if (array.length == 0) {
            throw new ServiceException("array cannot be empty");
        }

        // split a task to two
        FindMaxTask task1 = new FindMaxTask(array, 0, array.length / 2);
        FindMaxTask task2 = new FindMaxTask(array, array.length / 2, array.length);

        // waiting result from task
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(task1);
        Future<Integer> future2 = executorService.submit(task2);

        // reduce max value
        return Math.max(future1.get(), future2.get());

    }

}
