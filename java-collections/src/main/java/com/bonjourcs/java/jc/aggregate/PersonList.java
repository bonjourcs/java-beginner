package com.bonjourcs.java.jc.aggregate;

import com.bonjourcs.java.jc.aggregate.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description: person list
 * Date: 2018/5/8
 */
public class PersonList {

    private List<Person> people = new ArrayList<>();

    public void add(Person person) {
        people.add(person);
    }

    /**
     * show each person's name
     */
    public void printPeronName() {
        people.forEach(e -> System.out.println(e.getName()));
    }

    /**
     * only show male's name
     */
    public void printMaleName() {
        people.stream()
                .filter(e -> e.getSex() == Person.Sex.MALE)
                .forEach(e -> System.out.println(e.getName()));
    }

}
