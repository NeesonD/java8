package com.neeson.design.Observer;

import java.util.List;

/**
 * Created by daile on 2017/9/4.
 */
public class ForecastDisplay implements Observer,DiaplayElement {

    private WeatherData weatherData;

    private List<Float> forecastTemperatrues;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.forecastTemperatrues = this.weatherData.getForecastTemperatures();
        display();
    }

    @Override
    public void display() {
        int count = forecastTemperatrues.size();
        for (int i = 0;i<count;i++){
            System.out.println("第"+i+"天："+forecastTemperatrues.get(i));
        }
    }
}
