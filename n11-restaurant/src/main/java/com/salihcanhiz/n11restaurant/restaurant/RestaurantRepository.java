package com.salihcanhiz.n11restaurant.restaurant;

import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends SolrCrudRepository<Restaurant,String> {


}
