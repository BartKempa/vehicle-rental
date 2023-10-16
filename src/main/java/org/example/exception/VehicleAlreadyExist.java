package org.example.exception;

public class VehicleAlreadyExist extends RuntimeException{
    public VehicleAlreadyExist(String message) {
        super(message);
    }
}
