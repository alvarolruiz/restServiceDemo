package com.example.restServiceDemo.Exceptions;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Long id) {
        super(String.format("Could not find order %s",id));
    }
}
