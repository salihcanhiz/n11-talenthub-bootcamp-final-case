package com.salihcanhiz.finalcase.service;

import com.salihcanhiz.finalcase.client.RestaurantClient;
import com.salihcanhiz.finalcase.dto.RestaurantDTO;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.response.RecommendationResponse;
import com.salihcanhiz.finalcase.service.entityservice.CustomerEntityService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final RestaurantClient restaurantClient;
    private final CustomerEntityService customerEntityService;
    private final CommentService commentService;


    public List<RestaurantDTO> getRestaurantRecommendation(Long customerId) {
        List<RestaurantDTO> restaurantDTOList = restaurantClient.getAllRestaurant();
        Customer customer = customerEntityService.findByIdWithControl(customerId);
        List<RestaurantDTO> recommendationList = nearRestaurants(restaurantDTOList, customer.getLongitude(), customer.getLatitude());


        return recommendationList;
    }

    public List<RestaurantDTO> nearRestaurants(List<RestaurantDTO> restaurantList, double customerLongitude, double customerLatitude) {
        Map<String, Double> restaurantRates = commentService.getRestaurantRate();
        Map<String, Double> restaurantScores = new HashMap<>();
        List<RestaurantDTO> nearRestaurantList = new ArrayList<>();
        for (RestaurantDTO restaurant : restaurantList) {
            double distanceBetween = calculateDistance(customerLatitude, restaurant.latitude(), customerLongitude, restaurant.longitude());
            if (distanceBetween < 10 && distanceBetween > 0) {
                double rate = restaurantRates.getOrDefault(restaurant.id(), 0.0);
                double totalScore = (rate * 0.7) + (1 / (distanceBetween* 0.3));
                restaurantScores.put(restaurant.id(), totalScore);
                nearRestaurantList.add(restaurant);
            }
        }
        if(nearRestaurantList.size()==0){
            throw new RuntimeException("EROOR List is empty ");
        }
        nearRestaurantList.sort(Comparator.comparingDouble(restaurant -> -restaurantScores.getOrDefault(restaurant.id(),0.0)));
        return nearRestaurantList.subList(0,Math.min(nearRestaurantList.size(), 3));
    }

    public double calculateDistance(double latitude1, double latitude2, double longitude1, double longitude2) {
        double dLat = Math.toRadians(latitude2 - latitude1);
        double dLon = Math.toRadians(longitude2 - longitude1);

        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(latitude1) *
                        Math.cos(latitude2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        double distance = rad * c;
        return distance;
    }


}
