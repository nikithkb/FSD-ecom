package com.blueyonder.shopppingservice.exceptions;

public class ProductException extends Exception{

    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
