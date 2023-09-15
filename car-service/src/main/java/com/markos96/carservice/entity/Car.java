package com.markos96.carservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "/cars")
public class Car {

    @Id
    @GeneratedValue
    private Integer id;
    private String brand;
    private String model;
    private Integer userId;

    public Car(){}

    public Car(Integer id, String brand, String model, Integer userId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.userId = userId;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

}
