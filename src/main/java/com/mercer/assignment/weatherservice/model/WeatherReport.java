package com.mercer.assignment.weatherservice.model;

public class WeatherReport
{
    private String timezone;

    private String longitude;

    private String latitude;

    private String offset;

    private Hourly hourly;

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    public Hourly getHourly ()
    {
        return hourly;
    }

    public void setHourly (Hourly hourly)
    {
        this.hourly = hourly;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timezone = "+timezone+", longitude = "+longitude+", latitude = "+latitude+", offset = "+offset+", hourly = "+hourly+"]";
    }
}