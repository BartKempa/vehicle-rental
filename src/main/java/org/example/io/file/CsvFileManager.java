package org.example.io.file;

import org.example.exception.DataExportException;
import org.example.exception.DataImportException;
import org.example.exception.InvalidDataException;
import org.example.model.*;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager {
    private static final String VEHICLE_FILE_NAME = "Rental.csv";
    private static final String USER_FILE_NAME = "Rental_users.csv";

    private void exportUsers(Rental rental){
        Collection<User> userCollection = rental.getUsers().values();
        try (  FileWriter fileWriter = new FileWriter(USER_FILE_NAME);
               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for (User user : userCollection) {
                bufferedWriter.write(user.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
          throw new DataExportException("Błąd zapisu do pliku " + USER_FILE_NAME);
        }
    }
    private void importUsers(Rental rental){
        try (Scanner scanner = new Scanner(new File(USER_FILE_NAME))){
            while (scanner.hasNextLine()){
                String csvLine = scanner.nextLine();
                User user = createUserFormCsvLine(csvLine);
                rental.addUser(user);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Błąd wczystania danych z pliku " + USER_FILE_NAME);
        }
    }

    private User createUserFormCsvLine(String csvLine) {
        String[] split = csvLine.split(";");
        String firstName = split[0];
        String secondName = split[1];
        String pesel = split[2];
        return new RentalUser(firstName, secondName, pesel);
    }

    private void exportVehicle(Rental rental){
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

    private void importVehicle(Rental rental){
        try(Scanner scanner = new Scanner(new File(VEHICLE_FILE_NAME)))
        {
            while (scanner.hasNextLine()) {
                String csvLine = scanner.nextLine();
                Vehicle vehicle = createVehicleFromString(csvLine);
                rental.addVehicle(vehicle);
            }
        } catch (IOException e) {
            throw new DataImportException("Błąd wcztania danych z pliku " + VEHICLE_FILE_NAME);
        }
    }

    private Vehicle createVehicleFromString(String csvLine) {
        String[] split = csvLine.split(";");
        String type = split[0];
        if (Car.TYPE.equals(type)){
            return createCarFromString(csvLine);
        } if (Motorcycle.TYPE.equals(type)){
            return createMotorcycleFromString(csvLine);
        }  if (Truck.TYPE.equals(type)){
            return createTruckFromString(csvLine);
        }
        throw new InvalidDataException("Nieznany typo pojazdu " + type);
    }

    private Vehicle createTruckFromString(String csvLine) {
        String[] split = csvLine.split(";");
        String make = split[1];
        String model = split[2];
        int yearProduction = Integer.parseInt(split[3]);
        String registrationNumber = split[4];
        String transmission = split[5];
        int engineSize = Integer.parseInt(split[6]);
        String fuelType = split[7];
        int kilometers = Integer.parseInt(split[8]);
        int passengersNumber = Integer.parseInt(split[9]);
        int loadCapacity = Integer.parseInt(split[10]);
        return new Truck(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, passengersNumber, loadCapacity);
    }

    private Vehicle createMotorcycleFromString(String csvLine) {
        String[] split = csvLine.split(";");
        String make = split[1];
        String model = split[2];
        int yearProduction = Integer.parseInt(split[3]);
        String registrationNumber = split[4];
        String transmission = split[5];
        int engineSize = Integer.parseInt(split[6]);
        String fuelType = split[7];
        int kilometers = Integer.parseInt(split[8]);
        String motorcycleType = split[9];
        return new Motorcycle(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, motorcycleType);
    }

    private Vehicle createCarFromString(String csvLine) {
        String[] split = csvLine.split(";");
        String make = split[1];
        String model = split[2];
        int yearProduction = Integer.parseInt(split[3]);
        String registrationNumber = split[4];
        String transmission = split[5];
        int engineSize = Integer.parseInt(split[6]);
        String fuelType = split[7];
        int kilometers = Integer.parseInt(split[8]);
        String carCategory = split[9];
        int doorsNumber = Integer.parseInt(split[10]);
        int passengersNumber = Integer.parseInt(split[11]);
        return new Car(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, carCategory, doorsNumber, passengersNumber);
    }
}
