package com.ecommerce.customer.controller;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.request.CustomerRequest;
import com.ecommerce.customer.service.CustomerService;
import com.ecommerce.customer.validator.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;
    private final RequestValidator requestValidator;

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("Inside CustomerController createCustomer Method");
        requestValidator.validateCustomerRequest(customerRequest);
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable("customerId") long customerId) {
        log.info("Inside CustomerController getCustomer Method with customerId: {}", customerId);
        requestValidator.validateCustomerId(customerId);
        return customerService.getCustomer(customerId);
    }

    @GetMapping()
    public List<Customer> getCustomers() {
        log.info("Inside CustomerController getCustomers Method");
        return customerService.getCustomers();
    }

    @PutMapping("/{customerId}")
    public Customer editCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable("customerId") long customerId) {
        log.info("Inside CustomerController editCustomer Method with customerId: {}", customerId);
        requestValidator.validateCustomerId(customerId);
        requestValidator.validateCustomerRequest(customerRequest);
        return customerService.editCustomer(customerRequest, customerId);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") long customerId) {
        log.info("Inside CustomerController deleteCustomer Method with customerId: {}", customerId);
        requestValidator.validateCustomerId(customerId);
        customerService.deleteCustomer(customerId);
    }
}
