package com.inventory.api.handler;

public class ModelExceptionInUse extends RuntimeException{

    public ModelExceptionInUse(String message){
        super(message);
    }
}
