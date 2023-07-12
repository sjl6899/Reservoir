package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class ZJreservoir {
    private String name;
    private int nameId;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ZJreservoir{" +
                "name='" + name + '\'' +
                ", nameId=" + nameId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
