package com.bonjourcs.java.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Liang Chenghao
 * Description: class Fish
 * Date: 2019/1/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fish implements Serializable {

    /**
     * name
     */
    private String name;

    /**
     * calories
     */
    private int calories;

}
