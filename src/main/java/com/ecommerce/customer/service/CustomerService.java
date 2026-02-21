package com.ecommerce.customer.service;

import com.ecommerce.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> getCustomer(long customerId);

    Customer editCustomer(Customer customer);

    void deleteCustomer(long customerId);

    List<Customer> getCustomers();
}
