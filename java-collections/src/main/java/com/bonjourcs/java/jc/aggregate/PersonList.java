package com.bonjourcs.java.jc.aggregate;

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

    /**
     * get average age of male people
     *
     * @return average age
     */
    public double getMaleAverageAge() {
        return people.stream()
                .filter(e -> e.getSex() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
    }

    /**
     * get total age of person
     * @return total age
     */
    public int getTotalAge() {
        return people.stream()
                .map(Person::getAge)
                .reduce(0, (a, b) -> a + b);
    }

}
