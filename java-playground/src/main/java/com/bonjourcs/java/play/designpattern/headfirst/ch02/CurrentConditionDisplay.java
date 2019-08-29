package com.bonjourcs.java.play.designpattern.headfirst.ch02;

import lombok.Data;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/29
 */
@Data
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private int temperature;

    private int humidity;

    private Subject weatherData;


    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.printf("Current temperature is %d humidity is %d \n", temperature, humidity);
    }

    @Override
    public void update(int temp, int humidity, int pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

}
