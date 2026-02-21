package com.ecommerce.customer.validator;

import com.ecommerce.customer.exception.CustomerException;
import com.ecommerce.customer.exception.RequiredFieldsMissingException;
import com.ecommerce.customer.request.CustomerRequest;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class RequestValidator {

    public void validateCustomerRequest(CustomerRequest customerRequest) {
        if (Objects.isNull(customerRequest)) {
            log.info("[Error]: Invalid Create customer request: {}", customerRequest);
            throw new RequiredFieldsMissingException("Invalid Create customer request: {}"+ customerRequest);
        }
        if (StringUtils.isBlank(customerRequest.getCustomerFirstName()) || StringUtils.isBlank(customerRequest.getActive())
                || StringUtils.isBlank(customerRequest.getCustomerLastName()) || StringUtils.isBlank(customerRequest.getCustomerEmailId())) {
            log.info("[Error]: Invalid Create customer request: {}", customerRequest);
            throw new RequiredFieldsMissingException("Invalid Create customer request: {}"+ customerRequest);
        }
    }

    public void validateCustomerId(long customerId) {
        if (Objects.isNull(customerId)) {
            log.info("[Error]: Invalid CustomerId: {}", customerId);
            throw new CustomerException("Invalid CustomerId: {}"+ customerId);
        }
    }
}
