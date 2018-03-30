package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/30
 */
public class AdvancedMockServiceTest {

    @Test
    public void testPrintMockObject() {

        List<MockObject> mockObjects
                = new ArrayList<>(3);
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 10));
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 5));
        mockObjects.add(new MockObject(MockObject.Color.YELLOW, 10, 10));

        // specify search criteria
        AdvancedMockService advancedMockService = new AdvancedMockService();
        advancedMockService.printMockObject(mockObjects, mockObject ->
                mockObject.getLength() > 5
                        && mockObject.getWeight() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN
        );

    }

    @Test
    public void testPrintMockObject1() {

        List<MockObject> mockObjects
                = new ArrayList<>(3);
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 10));
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 5));
        mockObjects.add(new MockObject(MockObject.Color.YELLOW, 10, 10));

        AdvancedMockService advancedMockService = new AdvancedMockService();
        advancedMockService.printMockObject(mockObjects,
                mockObject -> mockObject.getLength() > 5
                        && mockObject.getWeight() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN,
                mockObject -> System.out.println(mockObject));
    }

}