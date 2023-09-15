package com.markos96.userservice.feignClient;

import com.markos96.userservice.data.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "car-service", url = "http://localhost:8003/car")
public interface CarFeignClient {

    @GetMapping("/getCars/{userId}")
    List<Car> getCarByUserId(@PathVariable Integer userId);
}
