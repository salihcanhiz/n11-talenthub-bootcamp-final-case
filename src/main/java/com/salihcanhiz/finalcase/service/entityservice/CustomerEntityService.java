package com.salihcanhiz.finalcase.service.entityservice;

import com.salihcanhiz.finalcase.dao.CustomerRepository;
import com.salihcanhiz.finalcase.entity.Customer;

import com.salihcanhiz.finalcase.general.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

    protected CustomerEntityService(CustomerRepository repository) {
        super(repository);
    }


}
