package com.bonjourcs.java.ltjl.cao;

import java.util.List;
import java.util.function.Consumer;
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

    /**
     * use more Java functional interface
     *
     * @param mockObjects objects to be filtered
     * @param predicate   object filter
     * @param consumer    object consumer
     */
    public void printMockObject(List<MockObject> mockObjects,
                                Predicate<MockObject> predicate,
                                Consumer<MockObject> consumer) {
        for (MockObject mockObject :
                mockObjects) {
            if (predicate.test(mockObject)) {
                consumer.accept(mockObject);
            }
        }
    }

}
