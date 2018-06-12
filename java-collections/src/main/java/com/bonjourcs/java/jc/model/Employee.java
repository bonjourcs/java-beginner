package com.bonjourcs.java.jc.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: employee model
 * Date: 2018/6/11
 */
@Data
public class Employee implements Comparable<Employee> {

    /**
     * hire date
     */
    private Date hireDate;
    /**
     * employee's name
     */
    private String name;

    /**
     * if o is hired before this employee, we say that
     * o is 'bigger' than this.
     *
     * @param o employee to compare
     * @return compare result
     */
    @Override
    public int compareTo(Employee o) {
        return o.hireDate.compareTo(this.hireDate);
    }

}
