package com.devfleet.workshop.exceptions;

public class WorkShopNotFound extends RuntimeException {
    public WorkShopNotFound(String message) {
        super(message);
    }
}
