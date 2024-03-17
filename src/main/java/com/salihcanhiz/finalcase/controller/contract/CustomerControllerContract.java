package com.salihcanhiz.finalcase.controller.contract;

import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.dto.RestaurantDTO;
import com.salihcanhiz.finalcase.general.RestResponse;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.request.CustomerUpdateRequest;
import com.salihcanhiz.finalcase.response.RecommendationResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerControllerContract {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO saveCustomer(CustomerSaveRequest request);

    void deleteCustomer(Long id);

    CustomerDTO updateCustomer(CustomerUpdateRequest request);

    List<RestaurantDTO> getRestaurantRecommendation(Long customerId);
}
