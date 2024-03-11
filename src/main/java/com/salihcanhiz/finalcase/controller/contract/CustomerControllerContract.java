package com.salihcanhiz.finalcase.controller.contract;

import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;

import java.util.List;

public interface CustomerControllerContract {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO saveCustomer(CustomerSaveRequest request);

    void deleteCustomer(Long id);
}
