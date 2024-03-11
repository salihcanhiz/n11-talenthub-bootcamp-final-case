package com.salihcanhiz.finalcase.mapper;

import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    Customer convertToCustomer(CustomerSaveRequest request);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDTOs(List<Customer> customers);
}
