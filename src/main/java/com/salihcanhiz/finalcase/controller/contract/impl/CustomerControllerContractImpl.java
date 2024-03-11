package com.salihcanhiz.finalcase.controller.contract.impl;

import com.salihcanhiz.finalcase.controller.contract.CustomerControllerContract;
import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.mapper.CustomerMapper;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@RequiredArgsConstructor
@Service

public class CustomerControllerContractImpl implements CustomerControllerContract {

    private final CustomerEntityService customerEntityService;
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


}
