package com.bonjourcs.java.jc.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/11
 */
public class EmployeeTest {


    private Collection<Employee> employees;

    @Before
    public void init() {

        employees = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        Employee employee = new Employee();
        calendar.set(2017, Calendar.SEPTEMBER, 1);
        employee.setHireDate(calendar.getTime());

        Employee employee1 = new Employee();
        calendar.set(2013, Calendar.OCTOBER, 2);
        employee1.setHireDate(calendar.getTime());

        Employee employee2 = new Employee();
        calendar.set(2018, Calendar.NOVEMBER, 3);
        employee2.setHireDate(calendar.getTime());

        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);

    }

    @Test
    public void testSortList() {

        List<Employee> list = new ArrayList<>(employees);
        Collections.sort(list);
        Assert.assertTrue(list.get(0).getHireDate().getTime()
                > list.get(1).getHireDate().getTime());

    }

}