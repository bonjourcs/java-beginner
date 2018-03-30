package com.bonjourcs.java.ltjl.cao;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Liang Chenghao
 * Description: advanced mock service
 * Date: 2018/3/30
 */
public class AdvancedMockService {

    /**
     * use Java functional interface
     *
     * @param mockObjects objects to be filtered
     * @param predicate   object filter
     */
    public void printMockObject(List<MockObject> mockObjects, Predicate<MockObject> predicate) {
        for (MockObject mockObject :
                mockObjects) {
            if (predicate.test(mockObject)) {
                System.out.println(mockObject);
            }
        }
    }

}
