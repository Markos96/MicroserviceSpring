package com.markos96.bike.service;

import com.markos96.bike.entity.Bike;
import com.markos96.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    private BikeRepository bikeRepository;

    public List<Bike> getAllBikes(){
        return bikeRepository.findAll();
    }

    public Optional<Bike> getBikeById(Integer id){
        return Optional.ofNullable(bikeRepository.findById(id))
                .orElse(null);
    }

    public Bike saveBike(Bike bike){
        Bike newBike = bikeRepository.save(bike);
        return newBike;
    }

    @Autowired
    public void setBikeRepository(BikeRepository bikeRepository) {this.bikeRepository = bikeRepository;}
}
