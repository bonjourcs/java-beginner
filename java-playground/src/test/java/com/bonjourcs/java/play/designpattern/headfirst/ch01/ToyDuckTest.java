package com.bonjourcs.java.play.designpattern.headfirst.ch01;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/23
 */
public class ToyDuckTest {

    @Test
    public void test(){

        Duck duck = new ToyDuck();
        duck.fly();
        duck.quack();

    }

}
