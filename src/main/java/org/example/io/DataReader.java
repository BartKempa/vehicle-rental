package org.example.io;

import org.example.model.*;

import java.util.Scanner;

public class DataReader {

    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public RentalUser createUser(){
        System.out.println("Imię:");
        String firstName = scanner.nextLine();
        System.out.println("Nazwisko:");
        String secondName = scanner.nextLine();
        System.out.println("PESEL:");
        String pesel = scanner.nextLine();
        return new RentalUser(firstName, secondName, pesel);
    }

    public Car createCar(){
        System.out.println("Marka samochodu:");
        String make = scanner.nextLine();
        System.out.println("Model samochodu:");
        String model = scanner.nextLine();
        System.out.println("Rok produkcji:");
        int yearProduction = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Numer rejestracyjny:");
        String registrationNumber = scanner.nextLine();
        System.out.println("Skrzynia biegów:");
        String transmission = scanner.nextLine();
        System.out.println("Pojemność silnika:");
        int engineSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rodzaj paliwa:");
        String fuelType = scanner.nextLine();
        System.out.println("Przebieg samochodu:");
        int kilometers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kategoria samochodu:");
        String carCategory = scanner.nextLine();
        System.out.println("Liczba drzwi:");
        int doorsNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Maksymalna liczba osób w samochodzie:");
        int passengersNumber = scanner.nextInt();
        scanner.nextLine();
        return new Car(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, carCategory, doorsNumber, passengersNumber);
    }

    public Truck createTruck(){
        System.out.println("Marka vana:");
        String make = scanner.nextLine();
        System.out.println("Model vana:");
        String model = scanner.nextLine();
        System.out.println("Rok produkcji:");
        int yearProduction = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Numer rejestracyjny:");
        String registrationNumber = scanner.nextLine();
        System.out.println("Skrzynia biegów:");
        String transmission = scanner.nextLine();
        System.out.println("Pojemność silnika:");
        int engineSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rodzaj paliwa:");
        String fuelType = scanner.nextLine();
        System.out.println("Przebieg samochodu:");
        int kilometers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Maksymalna liczba osób w vanie:");
        int passengersNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Maksymalna ładowonść vana:");
        int loadCapacity = scanner.nextInt();
        scanner.nextLine();
        return new Truck(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, passengersNumber, loadCapacity);
    }

    public Motorcycle createMotorcycle() {
        System.out.println("Marka motocykla:");
        String make = scanner.nextLine();
        System.out.println("Model motocykla:");
        String model = scanner.nextLine();
        System.out.println("Rok produkcji:");
        int yearProduction = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Numer rejestracyjny:");
        String registrationNumber = scanner.nextLine();
        System.out.println("Skrzynia biegów:");
        String transmission = scanner.nextLine();
        System.out.println("Pojemność silnika:");
        int engineSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Rodzaj paliwa:");
        String fuelType = scanner.nextLine();
        System.out.println("Przebieg motocykla:");
        int kilometers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Typ motocykla:");
        String motorcycleType = scanner.nextLine();
        return new Motorcycle(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, motorcycleType);
    }

    public int getInt(){
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public String getString(){
        return scanner.nextLine();
    }

    public void closeScanner(){
        scanner.close();
    }

}
