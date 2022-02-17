package com.demico.customers.customers.controller;

import com.demico.customers.customers.model.Customer;
import com.demico.customers.customers.request.CustomerRequest;
import com.demico.customers.customers.response.Response;
import com.demico.customers.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@CrossOrigin
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

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        boolean deleted = false;
        deleted = customerService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        log.info("get Customer {}", id);
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest request) {
        log.info("update Customer {}", id);
        return ResponseEntity.ok(customerService.update(id, request));
    }
}
