package com.ecommerce.customer.validator;

import com.ecommerce.customer.exception.CustomerException;
import com.ecommerce.customer.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class RequestValidator {

    public boolean validateCustomerRequest(Customer customer) {
        if (Objects.nonNull(customer) && (Objects.nonNull(customer.getCustomerId()) && Objects.nonNull(customer.getCustomerFirstName())
                && Objects.nonNull(customer.getCustomerLastName()) && Objects.nonNull(customer.getCustomerEmailId()))) {
            return true;
        }
        else {
            log.info("[Error]: Invalid Create customer request: {}", customer);
            throw new CustomerException("Invalid Create customer request: {}"+ customer);
        }
    }

    public boolean validateCustomerId(long customerId) {
        if (Objects.nonNull(customerId)) {
            return true;
        }
        else {
            log.info("[Error]: Invalid CustomerId: {}", customerId);
            throw new CustomerException("Invalid CustomerId: {}"+ customerId);
        }
    }
}
