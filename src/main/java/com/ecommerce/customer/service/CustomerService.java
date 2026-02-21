package com.ecommerce.customer.service;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.request.CustomerRequest;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(CustomerRequest customerRequest);

    Optional<Customer> getCustomer(long customerId);

    Customer editCustomer(CustomerRequest customer, long customerId);

    void deleteCustomer(long customerId);

    List<Customer> getCustomers();
}
