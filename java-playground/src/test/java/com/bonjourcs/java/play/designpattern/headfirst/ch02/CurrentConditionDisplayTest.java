package com.bonjourcs.java.play.designpattern.headfirst.ch02;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2019/8/29
 */
public class CurrentConditionDisplayTest {

    @Test
    public void test() {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(10, 20, 30);
        weatherData.removeRegister(currentConditionDisplay);

        System.out.println("remove an observer...");
        weatherData.setMeasurements(20, 10, 30);

        System.out.println("register an observer...");
        weatherData.register(currentConditionDisplay);
        weatherData.setMeasurements(20, 10, 30);

    }

}
