package org.example.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private String make;
    private String model;
    private int yearProduction;
    private String registrationNumber;
    private String transmission;
    private int engineSize;
    private String fuelType;
    private int kilometers;

    public Vehicle(String make, String model, int yearProduction, String registrationNumber, String transmission, int engineSize, String fuelType, int kilometers) {
        this.make = make;
        this.model = model;
        this.yearProduction = yearProduction;
        this.registrationNumber = registrationNumber;
        this.transmission = transmission;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.kilometers = kilometers;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String toString() {
        return " " + make +
                "; " + model +
                "; " + yearProduction +
                "; " + registrationNumber +
                "; " + transmission +
                "; " + engineSize +
                "; " + fuelType +
                "; " + kilometers;
    }

    public abstract String toCsv();
}
