package com.bonjourcs.java.play.domain;

import com.bonjourcs.java.play.annotation.CommonConstraint;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/1/11
 */
public class StudentTest {

    @Test
    public void testStudentConstraint() {

        Student student = new Student();
        System.out.println(student);

        Field[] fields = Student.class.getDeclaredFields();
        Arrays.stream(fields).forEach(
                f -> {
                    CommonConstraint commonConstraint = f.getAnnotation(CommonConstraint.class);
                    if (commonConstraint != null) {
                        System.out.println(commonConstraint.message());
                    }
                }
        );

    }

    @Test
    public void testStringLength() {

        String str = "公务员在职（40岁及以下）";
        System.out.println(str.length());

    }
}
