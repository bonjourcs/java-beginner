package com.bonjourcs.java.common.bean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/9
 */
public class PageTest {

    @Test
    public void testPagingObject() {

        Page<String> page = new Page<>();

        List<String> strings = new ArrayList<>();
        strings.add("AAA");
        strings.add("BBB");
        strings.add("CCC");

        page.init(1, 10, 100)
                .setData(strings);

        System.out.println(page);

    }
}