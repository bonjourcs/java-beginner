package com.bonjourcs.java.play.designpattern.headfirst.ch01;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/23
 */
public class NoFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly...");
    }

}
