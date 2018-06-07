package com.bonjourcs.java.jc.collection.interfaces;

import com.bonjourcs.java.jc.aggregate.Department;
import com.bonjourcs.java.jc.aggregate.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    /**
     * validate attribute map
     *
     * @param attrMap        map to validate
     * @param requiredAttrs  required attribute
     * @param permittedAttrs legal attribute
     * @param <K>            key type
     * @param <V>            value type
     * @return is validate
     */
    public static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs,
                                          Set<K> permittedAttrs) {

        Set<K> attrKeys = attrMap.keySet();
        boolean valid = true;

        if (!attrKeys.containsAll(requiredAttrs)) {
            // avoid using requiredAttrs directly
            Set<K> missing = new HashSet<>(requiredAttrs);
            missing.removeAll(attrKeys);
            System.out.println("Missing keys: " + missing);
            valid = false;
        }

        if (!permittedAttrs.containsAll(attrKeys)) {
            // avoid using attrKeys directly
            Set<K> illegals = new HashSet<>(attrKeys);
            illegals.removeAll(permittedAttrs);
            System.out.println("Illegal attributes: " + illegals);
            valid = false;
        }

        return valid;
    }

}
