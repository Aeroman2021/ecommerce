package com.project.ecommerce.exception;

public class CartFinalizeException extends RuntimeException{
    public CartFinalizeException() {
    }

    public CartFinalizeException(String message) {
        super(message);
    }

    public CartFinalizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
