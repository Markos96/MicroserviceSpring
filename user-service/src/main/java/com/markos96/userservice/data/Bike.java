package com.markos96.userservice.data;

public class Bike {

    private String brand;

    private String model;
    private Integer userId;

    public Bike(){}

    public Bike(String brand, String model, Integer userId) {
        this.brand = brand;
        this.model = model;
        this.userId = userId;
    }

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

}
