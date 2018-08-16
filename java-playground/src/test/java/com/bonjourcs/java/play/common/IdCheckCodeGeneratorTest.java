package com.bonjourcs.java.play.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/8/15
 */
public class IdCheckCodeGeneratorTest {

    @Test
    public void generateCheckCode() {

        String id = IdCheckCodeGenerator.generateCheckCode("33010819951225525");
        System.out.println(id);

    }

}