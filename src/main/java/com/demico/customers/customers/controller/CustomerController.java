package com.demico.customers.customers.controller;

import com.demico.customers.customers.request.CustomerRequest;
import com.demico.customers.customers.response.Response;
import com.demico.customers.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("New Customer Registration {}", customerRequest);
        customerService.save(customerRequest);
    }

    @PostMapping("/fraud")
    public void registerCustomerByFraud(@RequestBody CustomerRequest customerRequest) {
        log.info("New Customer By Fraud Registration {}", customerRequest);
        customerService.saveByFraud(customerRequest);
    }

    @GetMapping
    public ResponseEntity<Response> getCustomers() {
        return ResponseEntity.ok(
                new Response(LocalDateTime.now(), OK.value(), OK, "get all Customers", customerService.getAll()));
    }
}
