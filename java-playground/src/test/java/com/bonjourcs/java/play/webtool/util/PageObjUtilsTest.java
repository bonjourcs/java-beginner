package com.bonjourcs.java.play.webtool.util;

import com.bonjourcs.java.play.domain.Student;
import com.bonjourcs.java.play.webtool.bean.PageObj;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/2/19
 */
public class PageObjUtilsTest {

    private List<Student> studentList;

    @Before
    public void init() {

        Student student1 = new Student(10, "S1");
        Student student2 = new Student(20, "S2");
        Student student3 = new Student(10, "S3");
        Student student4 = new Student(10, "S4");

        studentList = new ArrayList<Student>() {
            {
                add(student1);
                add(student2);
                add(student3);
                add(student4);
            }
        };

    }

    @Test
    public void encapsulatePageObj() {

        PageObj pageObj = PageObjUtils.encapsulatePageObj(studentList, 4, 1, 2,
                s -> {
                    Student student = new Student();
                    student.setAge(s.getAge() + 1);
                    student.setName(s.getName() + s.getAge());
                    return student;
                });

        Assert.assertEquals(2, pageObj.getTotalPages());
        Assert.assertEquals(4, pageObj.getTotalItems());

    }
}