package com.neeson.design.Observer;

/**
 * Created by daile on 2017/9/4.
 */
public class CurrentConditionDisplay implements Observer,DiaplayElement {

    private WeatherData weatherData;

    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = this.weatherData.getTemperature();
        display();
    }

    @Override
    public void display() {
        System.out.println("当前温度："+temperature);
    }
}
