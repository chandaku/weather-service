package com.mercer.assignment.weatherservice.domain;

public class HourlyTemperature {
    private String hour;
    private Temperature temperature;

    public HourlyTemperature(String hour, Temperature temperature) {
        this.hour = hour;
        this.temperature = temperature;
    }

    public String getHour() {
        return hour;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}
