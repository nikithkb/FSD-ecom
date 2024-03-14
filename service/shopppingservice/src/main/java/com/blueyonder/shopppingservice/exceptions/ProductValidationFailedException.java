package com.blueyonder.shopppingservice.exceptions;

public class ProductValidationFailedException extends ProductException{

    public ProductValidationFailedException() {
        super();
    }

    public ProductValidationFailedException(String message) {
        super(message);
    }

    public ProductValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
