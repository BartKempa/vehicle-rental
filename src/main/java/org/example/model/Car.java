package org.example.model;

public class Car extends Vehicle{
    public static final String TYPE = "Samochód osobowy";
    private String carCategory;
    private int doorsNumber;
    private int passengersNumber;


    public Car(String make, String model, int yearProduction, String registrationNumber, String transmission, int engineSize, String fuelType, int kilometers) {
        super(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers);
    }

    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Override
    public String toString() {
        return  " " + carCategory +
                "; " + doorsNumber +
                "; " + passengersNumber +
                "; " + super.toString();
    }
}
