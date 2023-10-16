package org.example.io.file;

import org.example.exception.DataExportException;
import org.example.model.Rental;
import org.example.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class CsvFileManager {
    private static final String VEHICLE_FILE_NAME = "Rental.csv";
    private static final String USER_FILE_NAME = "Rental_users.csv";

    public void exportVehicle(Rental rental){
        Collection<Vehicle> vehicleCollection = rental.getVehicles().values();
        try (FileWriter fileWriter = new FileWriter(VEHICLE_FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for (Vehicle vehicle : vehicleCollection) {
                bufferedWriter.write(vehicle.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu do pliku " + VEHICLE_FILE_NAME);
        }
    }

    public void importVehicle(Rental rental){

    }

}
