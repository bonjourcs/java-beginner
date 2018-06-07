package com.bonjourcs.java.jc.model;

import com.bonjourcs.java.jc.annotation.Attribute;
import lombok.Data;

/**
 * @author Liang Chenghao
 * Description: class people
 * Date: 2018/6/7
 */
@Data
public class People {

    /**
     * name is required
     */
    @Attribute(required = true)
    private String name;

    /**
     * sex is required
     */
    @Attribute(required = true)
    private String sex;

    /**
     * address is not required
     */
    private String address;

}
