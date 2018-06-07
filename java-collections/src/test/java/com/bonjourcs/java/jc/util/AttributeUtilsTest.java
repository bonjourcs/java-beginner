package com.bonjourcs.java.jc.util;

import com.bonjourcs.java.jc.model.People;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/6/7
 */
public class AttributeUtilsTest {

    @Test
    public void testValidate() throws IllegalAccessException {

        People p = new People();
        p.setName("Kim");
        p.setSex("M");

        Assert.assertTrue(AttributeUtils.validate(p));

        p.setSex(null);
        Assert.assertFalse(AttributeUtils.validate(p));

    }

}