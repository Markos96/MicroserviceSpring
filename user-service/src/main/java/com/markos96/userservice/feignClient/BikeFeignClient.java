package com.markos96.userservice.feignClient;

import com.markos96.userservice.data.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bike-service")
public interface BikeFeignClient {

    @GetMapping("bike/getBikes/{userId}")
    List<Bike> getBikesByUserId(@PathVariable Integer userId);

    @PostMapping("/bike")
    Bike saveBike(@RequestBody Bike bike);

}
