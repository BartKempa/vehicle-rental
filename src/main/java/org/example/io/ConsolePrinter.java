package org.example.io;

import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Rental;
import org.example.model.Vehicle;

import java.util.Collection;
import java.util.Collections;

public class ConsolePrinter {

    public void printCars(Collection<Vehicle> vehicleCollection){
        //Collection<Vehicle> vehicleCollection = rental.getVehicles().values();
        int counter = 0;
        for (Vehicle vehicle : vehicleCollection) {
            if (vehicle instanceof Car){
                printLine(vehicle.toString());
                counter++;
            }
            if (counter == 0){
                printLine("Brak samochdów osobowych w bazie");
            }
        }
    }

    public void printMotorcycle(Collection<Vehicle> vehicleCollection){
        //Collection<Vehicle> vehicleCollection = rental.getVehicles().values();
        int counter = 0;
        for (Vehicle vehicle : vehicleCollection) {
            if (vehicle instanceof Motorcycle){
                printLine(vehicle.toString());
                counter++;
            }
            if (counter == 0){
                printLine("Brak motorów w bazie");
            }
        }
    }

    



    public void printLine(String text){
        System.out.println(text);
    }




}
