package com.salihcanhiz.finalcase.client;

import com.salihcanhiz.finalcase.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "restaurant",url="http://localhost:8082/api/v1/restaurants")
@EnableFeignClients
public interface RestaurantClient {

    @GetMapping("/{id}")
    RestaurantDTO getRestaurantById(@PathVariable String id);

    @GetMapping
     List<RestaurantDTO> getAllRestaurant();


}
