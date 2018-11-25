package com.mercer.assignment.weatherservice.domain;

import java.time.LocalDate;
import java.util.List;

public class Weather {
    private LocalDate date;
    private List<HourlyTemperature> hourlyTemperature;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<HourlyTemperature> getHourlyTemperature() {
        return hourlyTemperature;
    }

    public void setHourlyTemperature(List<HourlyTemperature> hourlyTemperature) {
        this.hourlyTemperature = hourlyTemperature;
    }
}




