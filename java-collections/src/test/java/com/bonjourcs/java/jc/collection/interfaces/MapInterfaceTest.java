package com.bonjourcs.java.jc.collection.interfaces;

import com.bonjourcs.java.jc.aggregate.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/7
 */
public class MapInterfaceTest {

    private List<Employee> employees;

    private Set<String> requiredAttrs;

    private Set<String> permittedAttrs;

    private Map<String, String> attributes;

    @Before
    public void init() {

        employees = new ArrayList<>(10);
        employees.add(new Employee("emp1", "John"));
        employees.add(new Employee("emp1", "Jane"));
        employees.add(new Employee("emp1", "Kim"));
        employees.add(new Employee("emp2", "John"));
        employees.add(new Employee("emp3", "Mike"));
        employees.add(new Employee("emp3", "Jane"));
        employees.add(new Employee("emp2", "Tomi"));
        employees.add(new Employee("emp2", "CiCi"));
        employees.add(new Employee("emp1", "CiCi"));
        employees.add(new Employee("emp1", "Alvin"));

        requiredAttrs = new HashSet<>();
        requiredAttrs.add("name");
        requiredAttrs.add("sex");

        permittedAttrs = new HashSet<>();
        requiredAttrs.add("name");
        requiredAttrs.add("sex");
        permittedAttrs.add("age");
        permittedAttrs.add("birth");

        attributes = new HashMap<>();
        attributes.put("name", "Kim");
        attributes.put("age", "10");
        attributes.put("address", "China");

    }

    @Test
    public void testSelectByDepartment() {
        MapInterface.selectByDepartment(employees).forEach((k, v)
                -> System.out.println(k.getDepName() + "-" + v.size()));
    }

    @Test
    public void testValidate() {
        Assert.assertFalse(MapInterface.validate(attributes, requiredAttrs, permittedAttrs));
    }


}