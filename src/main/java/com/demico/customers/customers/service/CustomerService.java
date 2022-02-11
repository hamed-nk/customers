package com.demico.customers.customers.service;

import com.demico.customers.customers.model.Customer;
import com.demico.customers.customers.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    void save(CustomerRequest request);

    List<Customer> getAll();

    List<Customer> getByEmail(String email);
}
