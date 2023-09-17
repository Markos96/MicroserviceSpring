package com.markos96.userservice.controller;

import com.markos96.userservice.data.Bike;
import com.markos96.userservice.data.Car;
import com.markos96.userservice.entity.User;
import com.markos96.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @CircuitBreaker(name = "bikesCircuitBreaker", fallbackMethod = "fallBackSaveBike")
    @PostMapping("/bike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable Integer userId, @RequestBody Bike bike){
        return ResponseEntity.ok(userService.saveBike(userId, bike));
    }

    @CircuitBreaker(name = "bikesCircuitBreaker", fallbackMethod = "fallBackGetBikes")
    @GetMapping("/getBikes/{userId}")
    public ResponseEntity<List<Bike>> getAllBikesByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getBikesByUserId(userId));
    }

    @CircuitBreaker(name = "carsCircuitBreaker", fallbackMethod = "fallBackGetCars")
    @GetMapping("/getCars/{userId}")
    public ResponseEntity<List<Car>> getAllCarsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getCarsByUserId(userId));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    private ResponseEntity<List<Car>> fallBackGetCars(@PathVariable Integer userId,  RuntimeException e){
        return new ResponseEntity("El usuario " +  userId + "tiene los coches en el taller", HttpStatus.OK);
    }

    private ResponseEntity<List<Bike>> fallBackGetBikes(@PathVariable Integer userId, RuntimeException e){
        return new ResponseEntity("El usuario " +  userId + "tiene las motos en el taller", HttpStatus.OK);
    }

    private ResponseEntity<Bike> fallBackSaveBike(@PathVariable Integer userId, @RequestBody Bike bike, RuntimeException e){
        return new ResponseEntity("El usuario " +  userId + "no tiene dinero para motos", HttpStatus.OK);
    }
}
