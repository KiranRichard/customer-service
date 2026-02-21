package com.ecommerce.customer.service.impl;

import com.ecommerce.customer.exception.CustomerException;
import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;
import com.ecommerce.customer.request.CustomerRequest;
import com.ecommerce.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setCustomerFirstName(customerRequest.getCustomerFirstName());
        customer.setCustomerLastName(customerRequest.getCustomerLastName());
        customer.setCustomerEmailId(customerRequest.getCustomerEmailId());
        customer.setActive(customerRequest.getActive());
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomer(long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerException("Customer id is not present and unable to update");
        }
        return optionalCustomer;
    }

    @Override
    public Customer editCustomer(CustomerRequest customerRequest, long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerException("Customer id is not present and unable to update");
        }
        Customer customer = optionalCustomer.get();
        customer.setCustomerFirstName(customerRequest.getCustomerFirstName());
        customer.setCustomerLastName(customerRequest.getCustomerLastName());
        customer.setCustomerEmailId(customer.getCustomerEmailId());
        customer.setActive(customerRequest.getActive());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long customerId) {
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerException("Customer id is not present and unable to delete");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
}
