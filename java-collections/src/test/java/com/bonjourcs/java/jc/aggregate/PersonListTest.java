package com.bonjourcs.java.jc.aggregate;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description: test for aggreate operation
 * Date: 2018/5/8
 */
public class PersonListTest {

    /**
     * initialize a personList object
     *
     * @return personList
     */
    private PersonList initPersonList() {

        PersonList personList = new PersonList();

        personList.add(new Person("Kim", LocalDate.now(), Person.Sex.MALE));
        personList.add(new Person("Jane", LocalDate.now(), Person.Sex.FEMALE));

        return personList;

    }

    @Test
    public void testPrintPeronName() {
        System.out.println("Print each person's name: ");
        PersonList personList = initPersonList();
        personList.printPeronName();
    }

    @Test
    public void testPrintMaleName(){
        System.out.println("Only print male's name: ");
        PersonList personList = initPersonList();
        personList.printMaleName();
    }

}