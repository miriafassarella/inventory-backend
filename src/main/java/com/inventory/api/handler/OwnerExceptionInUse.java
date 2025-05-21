package com.inventory.api.handler;

public class OwnerExceptionInUse extends RuntimeException{

    public OwnerExceptionInUse(String message) {
        super(message);
    }
}
