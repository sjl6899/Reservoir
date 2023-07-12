package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class Reservoir {
    private int reservoirId;
    private String country;
    private String name;
    private double height;
    private double width;
    private double longer;
    private double maxhg;
    private double bulk;
    private double inventory;
    private double area;
    private String component;
    private double longitude;
    private double latitude;
    private String stability;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getReservoirId() {
        return reservoirId;
    }

    public void setReservoirId(int reservoirId) {
        this.reservoirId = reservoirId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLonger() {
        return longer;
    }

    public void setLonger(double longer) {
        this.longer = longer;
    }

    public double getMaxhg() {
        return maxhg;
    }

    public void setMaxhg(double maxhg) {
        this.maxhg = maxhg;
    }

    public double getBulk() {
        return bulk;
    }

    public void setBulk(double bulk) {
        this.bulk = bulk;
    }

    public double getInventory() {
        return inventory;
    }

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getStability() {
        return stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    @Override
    public String toString() {
        return "Reservoir{" +
                "reservoirId=" + reservoirId +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", longer=" + longer +
                ", maxhg=" + maxhg +
                ", bulk=" + bulk +
                ", inventory=" + inventory +
                ", area=" + area +
                ", component='" + component + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", stability='" + stability + '\'' +
                '}';
    }
}
