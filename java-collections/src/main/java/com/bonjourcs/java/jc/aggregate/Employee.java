package com.bonjourcs.java.jc.aggregate;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/7
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = -7648040094478855881L;

    /**
     * department
     */
    private Department department;

    /**
     * employee id
     */
    private Integer empId;

    /**
     * employee name
     */
    private String empName;

    public Employee(String depName, String empName) {
        department = new Department();
        department.setDepName(depName);
        setEmpName(empName);
    }

}
