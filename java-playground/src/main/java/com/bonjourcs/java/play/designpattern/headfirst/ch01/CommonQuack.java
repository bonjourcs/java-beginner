package com.bonjourcs.java.play.designpattern.headfirst.ch01;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/23
 */
public class CommonQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack quack...");
    }

}
