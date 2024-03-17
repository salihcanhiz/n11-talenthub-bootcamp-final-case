package com.salihcanhiz.finalcase.controller;

import com.salihcanhiz.finalcase.client.RestaurantClient;
import com.salihcanhiz.finalcase.controller.contract.CustomerControllerContract;
import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.dto.RestaurantDTO;
import com.salihcanhiz.finalcase.general.RestResponse;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.request.CustomerUpdateRequest;
import com.salihcanhiz.finalcase.response.RecommendationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@Tag(name ="Customer Controller" )
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;
    private final RestaurantClient restaurantClient;
    @GetMapping
    @Operation(summary = "Get All Customers")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerControllerContract.getAllCustomers();
        return ResponseEntity.ok(RestResponse.of(allCustomers));
    }

    @PostMapping
    @Operation(summary = "Save Customer")
    public ResponseEntity<RestResponse<CustomerDTO>> saveCustomer(@Valid @RequestBody CustomerSaveRequest request) {
        CustomerDTO customerDTO = customerControllerContract.saveCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @PutMapping("/{debugCustomerId}")
    @Operation(summary = "Update Customer")
    public ResponseEntity<RestResponse<CustomerDTO>> updateCustomer(@Valid @PathVariable Long debugCustomerId, @RequestBody CustomerUpdateRequest request) {
        CustomerDTO customerDTO = customerControllerContract.updateCustomer(request);

        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Customer")
    public void deleteCustomer(@PathVariable @NotNull Long id) {
        customerControllerContract.deleteCustomer(id);
    }

    @Operation(summary = "Recommend to Customer",description = "Retrieves all active customers")
    @GetMapping("/recommendation/{customerId}")
    public List<RestaurantDTO> getRestaurantRecommendation(@PathVariable Long customerId) {

     return customerControllerContract.getRestaurantRecommendation(customerId);
    }


}
