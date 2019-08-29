package com.bonjourcs.java.play.designpattern.headfirst.ch02;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/27
 */
@Data
public class WeatherData implements Subject {

    private List<Observer> observerList;

    private int temp;

    private int humidity;

    private int pressure;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeRegister(Observer observer) {

        int i = observerList.indexOf(observer);

        if (i >= 0) {
            observerList.remove(i);
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void setMeasurements(int temp, int humidity, int pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }

    public void measureChanged() {
        notifyObservers();
    }

}
