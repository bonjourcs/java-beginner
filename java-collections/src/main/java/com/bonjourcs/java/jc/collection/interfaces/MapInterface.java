package com.bonjourcs.java.jc.collection.interfaces;

import com.bonjourcs.java.jc.aggregate.Department;
import com.bonjourcs.java.jc.aggregate.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Liang Chenghao
 * Description: operations on map
 * Date: 2018/6/7
 */
public class MapInterface {

    /**
     * group employee by department
     *
     * @param employees employee list
     * @return employee map
     */
    public static Map<Department, List<Employee>> selectByDepartment
    (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
