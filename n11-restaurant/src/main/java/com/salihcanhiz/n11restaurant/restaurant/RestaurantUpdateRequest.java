package com.salihcanhiz.n11restaurant.restaurant;

public record RestaurantUpdateRequest(String id,
                                      String name,
                                      double longitude,
                                      double latitude ) {
}
