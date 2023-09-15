package com.markos96.bike.controller;

import com.markos96.bike.entity.Bike;
import com.markos96.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bike")
public class BikeController {

    private BikeService bikeService;

    @PostMapping
    public ResponseEntity<Bike> saveBike(@RequestBody Bike bike){
        return ResponseEntity.ok(bikeService.saveBike(bike));
    }

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes(){
        return ResponseEntity.ok(bikeService.getAllBikes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Bike>> getBikeById(@PathVariable Integer id){
        return ResponseEntity.ok(bikeService.getBikeById(id));
    }

    @Autowired
    public void setBikeService(BikeService bikeService) {this.bikeService = bikeService;}
}
