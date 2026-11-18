package com.devfleet.workshop.exceptions;

public class PhoneOrEmailRequire extends RuntimeException {
    public PhoneOrEmailRequire(String message) {
        super(message);
    }
}
