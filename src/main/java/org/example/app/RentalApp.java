package org.example.app;

public class RentalApp {
    private static final String NAME = "Rental vehicles version 1.1";
    public static void main(String[] args) {
        System.out.println(NAME);

      RentalControl rentalControl = new RentalControl();
      rentalControl.controlLoop();



    }
}
