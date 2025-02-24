package com.service.customerservice.controller;

import com.service.customerservice.Entity.Customer;
import com.service.customerservice.json.CustomerResponse;
import com.service.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Customer API Controller",description = "Customer APIs to create, fetch and update the details")
@RequestMapping("/v1")
@RestController
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value ="/customerDetails/{firstName}")
    public List<Customer> CustomerDetails(@PathVariable String firstName){

        return customerService.fetchCustomerDetails(firstName);
    }

    @GetMapping(value ="/customerDetail/{firstName}")
    public ResponseEntity<List<Customer>>  CustomerDetail(@PathVariable String firstName){

        List<Customer> customerList = customerService.fetchCustomerDetails(firstName);

        if (customerList.isEmpty()) {
            return ResponseEntity.noContent().build();  // Returns 204 No Content if no customers found
        }
        return ResponseEntity.ok(customerList);
    }


    @GetMapping(value ="/customerDetailres/{firstName}")
    public ResponseEntity<CustomerResponse>  Customerresponse(@PathVariable String firstName){

        ResponseEntity<CustomerResponse> customerList = customerService.fetchCustomerDetailsresponse(firstName);
        
        return customerList;
    }

}
