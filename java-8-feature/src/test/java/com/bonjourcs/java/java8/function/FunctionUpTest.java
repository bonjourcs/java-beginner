package com.bonjourcs.java.java8.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/12/4
 */
public class FunctionUpTest {

    @Test
    public void testGetSubset() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        getSubSets(list).forEach(e -> {
            System.out.print("{");
            e.forEach(System.out::print);
            System.out.println("}");
        });

    }

    private List<List<Integer>> getSubSets(List<Integer> list) {

        if (list.isEmpty()) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(Collections.emptyList());
            return subsets;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subLists = getSubSets(rest);
        List<List<Integer>> subLists2 = insertAll(first, subLists);
        return concat(subLists, subLists2);

    }

    private List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> result = new ArrayList<>(b);
        result.addAll(a);
        return result;
    }

    private List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

}
