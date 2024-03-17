package com.salihcanhiz.n11restaurant.restaurant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDTO> getAllRestaurantsDTOs() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        return StreamSupport.stream(restaurants.spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RestaurantDTO saveRestaurant(RestaurantSaveRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.name());
        restaurant.setLongitude(request.longitude());
        restaurant.setLatitude(request.latitude());

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return new RestaurantDTO(savedRestaurant.getId(),
                savedRestaurant.getName(),
                savedRestaurant.getLongitude(),
                savedRestaurant.getLatitude());
    }

    public Optional<Restaurant> findById(String id) {
        return restaurantRepository.findById(id);
    }

    public Iterable<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public RestaurantDTO convertToDTO(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLongitude(),
                restaurant.getLatitude()
        );
    }

    public void delete(String id) {
        restaurantRepository.deleteById(id);
    }

    public RestaurantDTO updateRestaurant(RestaurantUpdateRequest request) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(request.id());
        if (restaurant.isPresent()) {
           Restaurant restaurantUpdate =restaurant.get();
            restaurantUpdate.setName(request.name());
            restaurantUpdate.setLongitude(request.longitude());
            restaurantUpdate.setLatitude(request.latitude());

            restaurantRepository.save(restaurantUpdate);

          return  convertToDTO(restaurantUpdate);
        }else {
            throw new RuntimeException("ERROR Restaurant not found");
        }


    }
}
