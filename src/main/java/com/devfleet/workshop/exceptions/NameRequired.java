package com.devfleet.workshop.exceptions;

public class NameRequired extends RuntimeException {
    public NameRequired(String message) {
        super(message);
    }
}
