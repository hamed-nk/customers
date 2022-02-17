package com.demico.customers.customers.service;

import com.demico.customers.customers.model.Customer;
import com.demico.customers.customers.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    Customer save(CustomerRequest request);

    Customer update(Long id, CustomerRequest request);

    void saveByFraud(CustomerRequest request);

    List<Customer> getAll();

    List<Customer> getByEmail(String email);

    Customer getById(Long id);

    Boolean delete(Long id);
}
