package com.devfleet.driver.exception;

public class NonExistentDriver extends RuntimeException {
    public NonExistentDriver(String message) {
        super(message);
    }
}
