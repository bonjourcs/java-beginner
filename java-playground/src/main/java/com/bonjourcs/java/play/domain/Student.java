package com.bonjourcs.java.play.domain;

import com.bonjourcs.java.play.annotation.CommonConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

/**
 * @author Liang Chenghao
 * Description: clas Student
 * Date: 2019/1/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @CommonConstraint(name = "年龄")
    private int age;

    @CommonConstraint(required = true, name = "姓名")
    @Pattern(regexp = "")
    private String name;

}
