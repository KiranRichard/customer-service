package com.ecommerce.customer.request;

import lombok.Data;

@Data
public class CustomerRequest {

    private String customerFirstName;
    private String customerLastName;
    private String active;
    private String customerEmailId;
}
