package com.ecommerce.customer.exception;

public class CustomerException extends RuntimeException {

    private String errorMessage;

    public CustomerException() {
        super();
    }

    public CustomerException(String errorMessage) {
        super(errorMessage);
    }
}
