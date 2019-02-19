package com.bonjourcs.java.play.webtool.bean;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/2/19
 */
public class PageObjTest {

    @Test
    public void testBuild() {

        PageObj p = PageObj.builder()
                .page(10)
                .size(0)
                .totalItems(100)
                .items(null)
                .build();

        System.out.println(p);
    }
}