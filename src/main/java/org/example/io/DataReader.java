package org.example.io;

import org.example.model.Car;
import org.example.model.Truck;

import java.util.Scanner;

public class DataReader {

    private Scanner scanner = new Scanner(System.in);

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
        return new Car(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers);
    }
    /*    public Truck(String make, String model, int yearProduction, String registrationNumber, String transmission, int engineSize, String fuelType, int kilometers, int passengersNumber, int loadCapacity) {
        super(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers);
        this.passengersNumber = passengersNumber;
        this.loadCapacity = loadCapacity;
    }
    }*/
    public Truck createTruck(){
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
        System.out.println("Maksymalna liczba osób w vanie:");
        int passengersNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Maksymalna ładowonść vana:");
        int loadCapacity = scanner.nextInt();
        scanner.nextLine();
        return new Truck(make, model, yearProduction, registrationNumber, transmission, engineSize, fuelType, kilometers, passengersNumber, loadCapacity);
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
