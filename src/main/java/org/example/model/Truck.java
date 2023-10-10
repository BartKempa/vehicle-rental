package org.example.model;

public class Truck extends Vehicle{
    public static final String TYPE = "Van";
    private int passengersNumber;
    private int loadCapacity;

    public Truck(String make, String model, int yearProduction, String registrationNumber, String transmission, int engineSize, String fuelType, int kilometers) {
        super(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers);
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return " " + passengersNumber +
                "; " + loadCapacity +
                "; " + super.toString();
    }
}
