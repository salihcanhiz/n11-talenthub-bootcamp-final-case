package com.salihcanhiz.finalcase.dao;

import com.salihcanhiz.finalcase.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
