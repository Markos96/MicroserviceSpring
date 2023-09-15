package com.markos96.carservice.controller;

import com.markos96.carservice.entity.Car;
import com.markos96.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        return ResponseEntity.ok(carService.saveBike(car));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllBikes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable Integer id){
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/getCars/{userId}")
    public ResponseEntity<List<Car>> getCarByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(carService.getCarByUserId(userId));
    }

    @Autowired
    public void setCarService(CarService carService) {this.carService = carService;}
}
