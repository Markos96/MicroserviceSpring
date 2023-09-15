package com.markos96.carservice.service;

import com.markos96.carservice.entity.Car;
import com.markos96.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public void setBikeRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllBikes(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Integer id){
        if(Objects.isNull(carRepository.findById(id))){
            throw new RuntimeException("Car not found");
        }
        return carRepository.findById(id);
    }

    public Car saveBike(Car car){
        Car newCar = carRepository.save(car);
        return car;
    }

    public List<Car> getCarByUserId(Integer userId){
        return carRepository.getCarByUserId(userId);
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {this.carRepository = carRepository;}
}
