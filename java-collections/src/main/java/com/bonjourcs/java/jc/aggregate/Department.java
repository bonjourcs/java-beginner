package com.bonjourcs.java.jc.aggregate;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liang Chenghao
 * Description: class department
 * Date: 2018/6/7
 */
@Data
public class Department implements Serializable {

    private static final long serialVersionUID = -5051543361950670040L;

    /**
     * department id
     */
    private Integer depId;
    /**
     * department name
     */
    private String  depName;

}
