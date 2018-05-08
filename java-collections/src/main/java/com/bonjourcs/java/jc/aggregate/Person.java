package com.bonjourcs.java.jc.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Liang Chenghao
 * Description: class Person to invoke aggregate operation
 * Date: 2018/5/8
 */
@Getter
@Setter
public class Person {

    /**
     * name of person
     */
    private String name;
    /**
     * birth of person
     */
    private LocalDate birthData;
    /**
     * sex of person
     */
    private Sex sex;

    public Person() {
    }

    public Person(String name, LocalDate birthData, Sex sex) {
        this.name = name;
        this.birthData = birthData;
        this.sex = sex;
    }

    /**
     * gender enumeration
     */
    public enum Sex {
        MALE, FEMALE
    }

}
