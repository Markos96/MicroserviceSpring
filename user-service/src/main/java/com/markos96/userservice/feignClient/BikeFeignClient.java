package com.markos96.userservice.feignClient;

import com.markos96.userservice.data.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-service", url = "http://localhost:8002/bike")
public interface BikeFeignClient {

    @GetMapping("/getBikes/{userId}")
    List<Bike> getBikesByUserId(@PathVariable Integer userId);

    @PostMapping
    Bike saveBike(@RequestBody Bike bike);

}
