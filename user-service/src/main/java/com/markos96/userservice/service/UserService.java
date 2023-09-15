package com.markos96.userservice.service;

import com.markos96.userservice.data.Bike;
import com.markos96.userservice.data.Car;
import com.markos96.userservice.entity.User;
import com.markos96.userservice.feignClient.BikeFeignClient;
import com.markos96.userservice.feignClient.CarFeignClient;
import com.markos96.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private CarFeignClient carFeignClient;
    private BikeFeignClient bikeFeignClient;

    public List<User> getAllUsers(){
        if(userRepository.findAll().isEmpty()){
            throw new RuntimeException("No hay usuarios en la lista");
        }
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("No existe el usuario ingresado");
        }
        return Optional.ofNullable(userRepository.findById(id)
                .orElse(null));
    }

    public User saveUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    public Bike saveBike(Integer userId, Bike bike){
        bike.setUserId(userId);
        Bike newBike = bikeFeignClient.saveBike(bike);
        return bike;
    }

    public List<Bike> getBikesByUserId(Integer userId){
        return bikeFeignClient.getBikesByUserId(userId);
    }

    public List<Car> getCarsByUserId(Integer userId){
        return carFeignClient.getCarByUserId(userId);
    }

    @Autowired
    public void setBikeFeignClient(BikeFeignClient bikeFeignClient) {this.bikeFeignClient = bikeFeignClient;}
    @Autowired
    public void setCarFeignClient(CarFeignClient carFeignClient) {this.carFeignClient = carFeignClient;}
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
