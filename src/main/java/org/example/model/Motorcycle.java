package org.example.model;

public class Motorcycle extends Vehicle{
    public static final String TYPE = "Motocykl";
    private String motorcycleType;

    public Motorcycle(String make, String model, int yearProduction, String registrationNumber, String transmission, int engineSize, String fuelType, int kilometers) {
        super(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers);
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    @Override
    public String toString() {
        return " " + motorcycleType +
                "; " + super.toString();
    }
}
