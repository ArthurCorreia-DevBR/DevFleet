package com.devfleet.workshop.exceptions;

public class NameTooLong extends RuntimeException {
    public NameTooLong(String message) {
        super(message);
    }
}
