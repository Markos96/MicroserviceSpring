package com.markos96.userservice.controller;

import com.markos96.userservice.data.Bike;
import com.markos96.userservice.entity.User;
import com.markos96.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/bike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable Integer userId, @RequestBody Bike bike){
        return ResponseEntity.ok(userService.saveBike(userId, bike));
    }

    @GetMapping("/getBikes/{userId}")
    public ResponseEntity<List<Bike>> getAllBikesByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getBikesByUserId(userId));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
