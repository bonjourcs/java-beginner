package com.bonjourcs.java.play.designpattern.headfirst.ch01;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/23
 */
public class SuperDuckTest {

    @Test
    public void test(){

        FlyBehavior flyBehavior = new RocketFly();
        QuackBehavior quackBehavior = new CommonQuack();

        Duck duck = new SuperDuck();
        duck.setFlyBehavior(flyBehavior);
        duck.setQuackBehavior(quackBehavior);

        duck.fly();
        duck.quack();

    }

}
