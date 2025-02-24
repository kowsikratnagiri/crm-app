package com.service.customerservice.repository;

import com.service.customerservice.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer ,Long> {


    @Query(value="select * from customer.customers where first_name ilike :firstName%",nativeQuery = true)
    public List<Customer> findByName(String firstName);
}
