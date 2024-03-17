package com.salihcanhiz.finalcase.mapper;

import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.request.CustomerUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping(target = "status", constant = "ACTIVE")
    Customer convertToCustomer(CustomerSaveRequest request);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDTOs(List<Customer> customers);
    @Mapping(target = "id", ignore = true)
    void updateCustomerFields(@MappingTarget Customer customer, CustomerUpdateRequest request);
}
