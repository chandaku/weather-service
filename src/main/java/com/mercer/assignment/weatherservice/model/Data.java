package com.mercer.assignment.weatherservice.model;
public class Data
{
    private String summary;

    private String icon;

    private String windGust;

    private String pressure;

    private String visibility;

    private String cloudCover;

    private String apparentTemperature;

    private String precipIntensity;

    private String temperature;

    private String dewPoint;

    private String ozone;

    private String time;

    private String windSpeed;

    private String humidity;

    private String windBearing;

    private String uvIndex;

    private String precipProbability;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getWindGust ()
    {
        return windGust;
    }

    public void setWindGust (String windGust)
    {
        this.windGust = windGust;
    }

    public String getPressure ()
    {
        return pressure;
    }

    public void setPressure (String pressure)
    {
        this.pressure = pressure;
    }

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public String getCloudCover ()
    {
        return cloudCover;
    }

    public void setCloudCover (String cloudCover)
    {
        this.cloudCover = cloudCover;
    }

    public String getApparentTemperature ()
    {
        return apparentTemperature;
    }

    public void setApparentTemperature (String apparentTemperature)
    {
        this.apparentTemperature = apparentTemperature;
    }

    public String getPrecipIntensity ()
    {
        return precipIntensity;
    }

    public void setPrecipIntensity (String precipIntensity)
    {
        this.precipIntensity = precipIntensity;
    }

    public String getTemperature ()
    {
        return temperature;
    }

    public void setTemperature (String temperature)
    {
        this.temperature = temperature;
    }

    public String getDewPoint ()
    {
        return dewPoint;
    }

    public void setDewPoint (String dewPoint)
    {
        this.dewPoint = dewPoint;
    }

    public String getOzone ()
    {
        return ozone;
    }

    public void setOzone (String ozone)
    {
        this.ozone = ozone;
    }

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getWindSpeed ()
    {
        return windSpeed;
    }

    public void setWindSpeed (String windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    public String getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (String humidity)
    {
        this.humidity = humidity;
    }

    public String getWindBearing ()
    {
        return windBearing;
    }

    public void setWindBearing (String windBearing)
    {
        this.windBearing = windBearing;
    }

    public String getUvIndex ()
    {
        return uvIndex;
    }

    public void setUvIndex (String uvIndex)
    {
        this.uvIndex = uvIndex;
    }

    public String getPrecipProbability ()
    {
        return precipProbability;
    }

    public void setPrecipProbability (String precipProbability)
    {
        this.precipProbability = precipProbability;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", icon = "+icon+", windGust = "+windGust+", pressure = "+pressure+", visibility = "+visibility+", cloudCover = "+cloudCover+", apparentTemperature = "+apparentTemperature+", precipIntensity = "+precipIntensity+", temperature = "+temperature+", dewPoint = "+dewPoint+", ozone = "+ozone+", time = "+time+", windSpeed = "+windSpeed+", humidity = "+humidity+", windBearing = "+windBearing+", uvIndex = "+uvIndex+", precipProbability = "+precipProbability+"]";
    }
}