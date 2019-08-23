package com.bonjourcs.java.play.designpattern.headfirst.ch01;

/**
 * @author Liang Chenghao
 * Description: a duck subclass
 * Date: 2019/8/23
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        setFlyBehavior(new NoFly());
        setQuackBehavior(new CommonQuack());
    }

}
