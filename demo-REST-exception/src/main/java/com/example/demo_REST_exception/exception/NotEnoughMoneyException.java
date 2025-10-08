package com.example.demo_REST_exception.exception;


public class NotEnoughMoneyException extends RuntimeException {


    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
