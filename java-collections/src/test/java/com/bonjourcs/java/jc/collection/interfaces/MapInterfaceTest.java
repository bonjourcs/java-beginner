package com.bonjourcs.java.jc.collection.interfaces;

import com.bonjourcs.java.jc.aggregate.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/7
 */
public class MapInterfaceTest {

    private List<Employee> employees;

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

    }

    @Test
    public void testSelectByDepartment() {
        MapInterface.selectByDepartment(employees).forEach((k, v)
                -> System.out.println(k.getDepName() + "-" + v.size()));
    }


}