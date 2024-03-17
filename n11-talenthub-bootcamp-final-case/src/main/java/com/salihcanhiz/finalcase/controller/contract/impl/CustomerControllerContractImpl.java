package com.salihcanhiz.finalcase.controller.contract.impl;

import com.salihcanhiz.finalcase.controller.contract.CustomerControllerContract;
import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.dto.RestaurantDTO;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.general.RestResponse;
import com.salihcanhiz.finalcase.mapper.CustomerMapper;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.request.CustomerUpdateRequest;

import com.salihcanhiz.finalcase.response.RecommendationResponse;
import com.salihcanhiz.finalcase.service.CustomerService;
import com.salihcanhiz.finalcase.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CustomerControllerContractImpl implements CustomerControllerContract {

    private final CustomerEntityService customerEntityService;
    private final CustomerService customerService;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerEntityService.findAll();

        return CustomerMapper.INSTANCE.convertToCustomerDTOs(customerList);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        customer=customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerEntityService.delete(id);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerUpdateRequest request) {
        Customer customer = customerEntityService.findByIdWithControl(request.id());
        CustomerMapper.INSTANCE.updateCustomerFields(customer, request);
        customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<RestaurantDTO> getRestaurantRecommendation(Long customerId) {
        return customerService.getRestaurantRecommendation(customerId);
    }


}
