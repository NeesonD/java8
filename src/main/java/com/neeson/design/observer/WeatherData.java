package com.neeson.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daile on 2017/9/4.
 */
public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temperature;
    private float humidity;
    private float pressure;
    private List<Float> forecastTemperatures;

    public WeatherData(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers){
            observer.update();
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity,float pressure,List<Float> forecastTemperatures){
        this.temperature =  temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        measurementsChanged();
    }

    public float getTemperature(){
        return temperature;
    }

    public float getHumidity(){
        return humidity;
    }

    public List<Float> getForecastTemperatures(){
        return forecastTemperatures;
    }
}
