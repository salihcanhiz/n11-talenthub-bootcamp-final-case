package com.salihcanhiz.finalcase.controller.contract.impl;

import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.request.CustomerUpdateRequest;
import com.salihcanhiz.finalcase.service.CustomerService;
import com.salihcanhiz.finalcase.service.entityservice.CustomerEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {
    @Mock
    private CustomerEntityService customerEntityService;

    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CustomerControllerContractImpl customerControllerContractImpl;

    @Test
    void shouldGetAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setName("name1");
        customer1.setSurname("surname1");
        Customer customer2 = new Customer();
        customer2.setName("name2");
        customer2.setSurname("surname2");
        Customer customer3 = new Customer();
        customer3.setName("name3");
        customer3.setSurname("surname3");
        Customer customer4 = new Customer();
        customer4.setName("name4");
        customer4.setSurname("surname4");
        List<Customer> customers = new ArrayList<>();
        Customer customer5 = new Customer();
        customer5.setName("name5");
        customer5.setSurname("surname5");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        //when
        Mockito.when(customerEntityService.findAll()).thenReturn(customers);

        List<CustomerDTO> results = customerControllerContractImpl.getAllCustomers();

        //then
        assertEquals(customers.size(), results.size());

        for (int i = 0; i < results.size(); i++) {
            CustomerDTO result = results.get(i);
            Customer eachCustomer = customers.get(i);

            assertEquals(eachCustomer.getName(), result.name());
            assertEquals(eachCustomer.getSurname(), result.surname());
        }
    }

    @Test
    void shouldSaveCustomer() {
        CustomerSaveRequest request = new CustomerSaveRequest("Salihcan","Hız",LocalDate.of(2000,1,13)
                ,"151252","3521521","salihcanhiz20@gmail.com",20.9852141,40.9854215);

       customerControllerContractImpl.saveCustomer(request);

       verify(customerEntityService,times(1)).save(any(Customer.class));

    }

    @Test
    void shouldDeleteCustomer() {
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);

        Mockito.doNothing().when(customerEntityService).delete(customerId);
        customerControllerContractImpl.deleteCustomer(customerId);
        Mockito.verify(customerEntityService,Mockito.times(1)).delete(customerId);


    }

    @Test
    void shouldUpdateCustomer() {
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(1L,"John","hız",
                LocalDate.of(2010,5,10),"54215412","salihcanh@gmail.com",21.41,42.415);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Salih");
        customer.setSurname("hız");
        customer.setBirthDate(LocalDate.of(2010,5,10));
        customer.setPhoneNumber("54215412");
        customer.setEmail("salihcanh@gmail.com");
        customer.setLongitude(21.41);
        customer.setLatitude(42.415);

        Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);

        CustomerDTO results = customerControllerContractImpl.updateCustomer(updateRequest);

        assertEquals(1L,results.id());
        assertEquals(updateRequest.name(),results.name());
        assertEquals(updateRequest.surname(),results.surname());
        assertEquals(updateRequest.birthDate(),results.birthDate());
        assertEquals(updateRequest.phoneNumber(),results.phoneNumber());
        assertEquals(updateRequest.email(),results.email());
        assertEquals(updateRequest.longitude(),results.longitude());
        assertEquals(updateRequest.latitude(),results.latitude());
    }

    @Test void shouldGetRestaurantRecommendation(){

    }
}