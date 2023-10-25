package org.example.io;

import org.example.model.*;

import java.util.Collection;

public class ConsolePrinter {

/*
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
*/

    public void printCars(Collection<Vehicle> vehicleCollection){
         long count = vehicleCollection.stream()
                .filter(v -> v instanceof Car)
                .map(Vehicle::toString)
                .peek(this::printLine)
                .count();
         if (count == 0)
             printLine("rak samochdów osobowych w bazie ");
    }


    public void printMotorcycle(Collection<Vehicle> vehicleCollection){
        long count = vehicleCollection.stream()
                .filter(v -> v instanceof Motorcycle)
                .map(Vehicle::toString)
                .peek(this::printLine)
                .count();
        if (count == 0)
            printLine("Brak motorów w bazie");
    }

    public void printTrucks(Collection<Vehicle> vehicleCollection){
        long count = vehicleCollection.stream()
                .filter(v -> v instanceof Truck)
                .map(Vehicle::toString)
                .peek(this::printLine)
                .count();
        if (count == 0)
            printLine("Brak vanów w bazie");
    }

    public void printUsers(Collection<User> userCollection){
        userCollection.stream()
                .map(User::toString)
                .forEach(System.out::println);
    }

    public void printLine(String text){
        System.out.println(text);
    }
}
