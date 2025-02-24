package com.service.customerservice.serviceimpl;

import com.service.customerservice.Entity.Customer;
import com.service.customerservice.Entity.CustomerDt;
import com.service.customerservice.Entity.CustomerDto;
import com.service.customerservice.json.CustomerResponse;
import com.service.customerservice.repository.CustomerRepository;
import com.service.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> fetchCustomerDetails(String firstName){
        List<Customer>  customerList = customerRepository.findByName(firstName);
        customerList.stream().forEach(customer -> customer.setFirstName(customer.getFirstName()+" "+customer.getLastName()));
        return customerList;
    }


    public ResponseEntity<List<Customer>> fetchCustomerDetail(String firstName){
        return null;
    }


    public ResponseEntity<CustomerResponse> fetchCustomerDetailsresponse(String firstName){
        List<Customer> customerList = customerRepository.findByName(firstName);

        customerList.stream().forEach(customer -> customer.setFirstName(customer.getFirstName()+" "+customer.getLastName()));


        List<CustomerDto> customerDtos = customerList.stream().
                map(Customer->new CustomerDto(Customer.getCustomerId(),
                        Customer.getFirstName(),
                        Customer.getLastName(),
                        Customer.getCompanyName(),
                        Customer.getAddress(),
                        Customer.getCity(),
                        Customer.getCounty(),
                        Customer.getState(),
                        Customer.getZip(),
                        Customer.getPhone1(),
                        Customer.getPhone2(),
                        Customer.getEmail(),
                        Customer.getWeb())).toList();
        customerDtos.forEach(System.out::println);


        List<CustomerDt> customerDtoslist = customerList.stream()
                .map(customer -> new CustomerDt(customer.getCustomerId(), customer.getFirstName())) // Only mapping required fields
                .toList();


        CustomerResponse customerResponse = new CustomerResponse();

        List<Customer> customerLists =customerList.stream().map(customer -> {Customer customer1 = new Customer();
            customer1.setCustomerId(customer.getCustomerId());
            customer1.setFirstName(customer.getFirstName());
            return customer1;
        }).collect(Collectors.toList());
            customerResponse.setData(customerLists);
            customerResponse.setCustomerType("Regular");
        return ResponseEntity.ok(customerResponse);
    }

}
