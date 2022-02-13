package com.demico.customers.customers.serviceImpl;

import com.demico.customers.customers.model.Customer;
import com.demico.customers.customers.repository.CustomerRepository;
import com.demico.customers.customers.request.CustomerRequest;
import com.demico.customers.customers.response.FraudResponse;
import com.demico.customers.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;

    public List<Customer> getByEmail(String email) {
        return customerRepository.getByEmail(email);
    }

    @Override
    @Transactional
    public Customer save(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    @Transactional
    public void saveByFraud(CustomerRequest request) {
        Customer customer = save(request);
        log.info("end save", customer.getId());
        FraudResponse fraudResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudResponse.class,
                customer.getId()
        );
        log.info("end fraud");
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
