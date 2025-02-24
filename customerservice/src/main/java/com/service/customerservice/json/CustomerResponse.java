package com.service.customerservice.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.service.customerservice.Entity.Customer;

import java.util.List;
@JsonPropertyOrder({"customerType","data" }) // Ensures "data" comes first
public class CustomerResponse {

    private String CustomerType;
    private List<Customer> data;

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }
}
