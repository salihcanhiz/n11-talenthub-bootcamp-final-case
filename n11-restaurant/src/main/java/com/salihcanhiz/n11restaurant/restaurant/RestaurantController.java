package com.salihcanhiz.n11restaurant.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController

@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;


    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping()
    public List<RestaurantDTO> getAllRestaurant() {
        return restaurantService.getAllRestaurantsDTOs();
    }

    @PutMapping("/{debugRestaurantId}")
    public RestaurantDTO updateRestaurant(@PathVariable String debugRestaurantId,@RequestBody RestaurantUpdateRequest request) {
        return restaurantService.updateRestaurant(request);
    }


    @PostMapping
    public RestaurantDTO saveRestaurant(@RequestBody RestaurantSaveRequest request) {
        return restaurantService.saveRestaurant(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        restaurantService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id) {
        return restaurantService.findById(id);
    }


}
