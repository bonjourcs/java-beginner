package com.bonjourcs.java.play.designpattern.headfirst.ch02;

/**
 * @author Liang Chenghao
 * Description: Subject interface
 * Date: 2019/8/27
 */
public interface Subject {

    void register(Observer observer);

    void removeRegister(Observer observer);

    void notifyObservers();

}
