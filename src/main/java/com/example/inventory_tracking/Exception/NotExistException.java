package com.example.inventory_tracking.Exception;

public class NotExistException extends RuntimeException{
    public NotExistException(String message) {
        super(message);
    }
}
