package com.markos96.bike.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue
    private Integer id;
    private String brand;
    private String model;

    public Bike(){}

    public Bike(Integer id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}
}
