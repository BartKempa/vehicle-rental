package org.example.model;

public class Motorcycle extends Vehicle{
    public static final String TYPE = "Motocykl";
    private String motorcycleType;

    public Motorcycle(String make, String model, int yearProduction, String registrationNumber, String transmission, int engineSize, String fuelType, int kilometers, String motorcycleType) {
        super(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers);
        this.motorcycleType = motorcycleType;
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
    @Override
    public String toCsv() {
        return TYPE + ";" +
                getMake() + ";" +
                getModel() + ";" +
                getYearProduction() + ";" +
                getRegistrationNumber() + ";" +
                getTransmission() + ";" +
                getEngineSize() + ";" +
                getFuelType() + ";" +
                getKilometers() + ";" +
                getMotorcycleType();
    }
}
