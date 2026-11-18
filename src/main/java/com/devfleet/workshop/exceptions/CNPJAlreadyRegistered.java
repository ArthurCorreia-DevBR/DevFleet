package com.devfleet.workshop.exceptions;

public class CNPJAlreadyRegistered extends RuntimeException {
    public CNPJAlreadyRegistered(String message) {
        super(message);
    }
}
