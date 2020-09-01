package com.x00122898.weatherapiclient;

public class WeatherInformation {

    private int id;
    private String city;
    private String conditions;
    private int maxTemp;
    private int minTemp;
    private String windDirect;
    private int windSpeed;
    private String outlook;

    public WeatherInformation(int id, String city, String conditions, int maxTemp, int minTemp, String windDirect, int windSpeed, String outlook) {
        this.id = id;
        this.city = city;
        this.conditions = conditions;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.windDirect = windDirect;
        this.windSpeed = windSpeed;
        this.outlook = outlook;
    }

    public WeatherInformation() {
    }

    @Override
    public String toString() {
        return "WeatherInformation{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", conditions='" + conditions + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", windDirect='" + windDirect + '\'' +
                ", windSpeed=" + windSpeed +
                ", outlook=" + outlook +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public String getWindDirect() {
        return windDirect;
    }

    public void setWindDirect(String windDirect) {
        this.windDirect = windDirect;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }
}
