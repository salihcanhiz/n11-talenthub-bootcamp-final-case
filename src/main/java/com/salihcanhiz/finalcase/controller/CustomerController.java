package com.salihcanhiz.finalcase.controller;



import com.salihcanhiz.finalcase.controller.contract.CustomerControllerContract;
import com.salihcanhiz.finalcase.dto.CustomerDTO;
import com.salihcanhiz.finalcase.general.RestResponse;
import com.salihcanhiz.finalcase.request.CustomerSaveRequest;
import com.salihcanhiz.finalcase.request.CustomerUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerControllerContract.getAllCustomers();
        return ResponseEntity.ok(RestResponse.of(allCustomers));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> saveCustomer(@RequestBody CustomerSaveRequest request) {
        CustomerDTO customerDTO = customerControllerContract.saveCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @DeleteMapping
    public void deleteCustomer(@PathVariable Long id) {
        customerControllerContract.deleteCustomer(id);
    }
    @PutMapping("/{debugCustomerId}")
    public ResponseEntity<RestResponse<CustomerDTO>> updateCustomer(@PathVariable Long debugCustomerId,@RequestBody CustomerUpdateRequest request){
        CustomerDTO customerDTO = customerControllerContract.updateCustomer(request);

        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }


}
