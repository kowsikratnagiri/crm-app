package com.service.customerservice.Entity;

public record CustomerDto(Long customerId,// Primary Key
                          String firstName,
                          String lastName,
                          String companyName,
                          String address,
                          String city,
                          String county,
                          String state,
                          String zip,
                          String phone1,
                          String phone2,
                          String email,
                          String web) {
}
