package com.example.inventory_tracking.Exception;

public class ItemEmptyNameException extends RuntimeException{
    public ItemEmptyNameException(String message){
        super(message);
    }
}
