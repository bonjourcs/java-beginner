package com.bonjourcs.java.play.designpattern.headfirst.ch01;

import lombok.Data;

/**
 * @author Liang Chenghao
 * Description: class duck
 * Date: 2019/8/23
 */
@Data
public abstract class Duck {

    /**
     * duck's color
     */
    private String color;

    /**
     * leg amount
     */
    private int leg;

    /**
     * fly component
     */
    private FlyBehavior flyBehavior;

    /**
     * quack component
     */
    private QuackBehavior quackBehavior;

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

}
