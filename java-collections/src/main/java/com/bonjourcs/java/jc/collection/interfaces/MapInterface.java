package com.bonjourcs.java.jc.collection.interfaces;

import com.bonjourcs.java.jc.aggregate.Department;
import com.bonjourcs.java.jc.aggregate.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
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

    /**
     * @param filePath
     * @param minCount
     * @return group count
     * @throws IOException
     */
    public static int groupWords(String filePath, int minCount) throws IOException {

        Map<String, List<String>> map = new HashMap<>();
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNext()) {
            String word = scanner.next();
            String alpha = alphabetize(word);
            List<String> list = map.computeIfAbsent(alpha, k -> new ArrayList<>());
            list.add(word);
        }

        int count = 0;
        for (List<String> list : map.values()) {
            if (list.size() >= minCount) {
                count++;
            }
        }

        return count;

    }

    private static String alphabetize(String s) {
        byte[] bytes = s.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

}
