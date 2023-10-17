package org.example.io;

import org.example.model.*;

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

    public void printTrucks(Collection<Vehicle> vehicleCollection){
        //Collection<Vehicle> vehicleCollection = rental.getVehicles().values();
        int counter = 0;
        for (Vehicle vehicle : vehicleCollection) {
            if (vehicle instanceof Truck){
                printLine(vehicle.toString());
                counter++;
            }
            if (counter == 0){
                printLine("Brak vanów w bazie");
            }
        }
    }

    public void printUsers(Collection<RentalUser> userCollection){
        int counter = 0;
        for (User user : userCollection) {
           printLine(user.toString());
           counter++;
        } if (counter == 0) {
            printLine("Brak użytkowników w bazie");
        }
    }

    public void printLine(String text){
        System.out.println(text);
    }




}
