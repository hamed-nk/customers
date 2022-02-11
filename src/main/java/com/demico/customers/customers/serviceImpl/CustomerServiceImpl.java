package com.demico.customers.customers.serviceImpl;

import com.demico.customers.customers.model.Customer;
import com.demico.customers.customers.repository.CustomerRepository;
import com.demico.customers.customers.request.CustomerRequest;
import com.demico.customers.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getByEmail(String email) {
        return customerRepository.getByEmail(email);
    }

    @Override
    @Transactional
    public void save(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
