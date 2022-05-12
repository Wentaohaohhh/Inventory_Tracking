package com.example.inventory_tracking.Exception;

public class ItemEmptyException extends RuntimeException{

    public ItemEmptyException(String s) {
        super(s);
    }
}
