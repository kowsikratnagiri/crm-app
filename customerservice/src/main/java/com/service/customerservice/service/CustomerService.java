package com.service.customerservice.service;

import com.service.customerservice.Entity.Customer;
import com.service.customerservice.json.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

   public List<Customer> fetchCustomerDetails(String firstName);

   public ResponseEntity<List<Customer>> fetchCustomerDetail(String firstName);

   public ResponseEntity<CustomerResponse> fetchCustomerDetailsresponse(String firstName);
}
