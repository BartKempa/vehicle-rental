package org.example.app;

import org.example.exception.DataExportException;
import org.example.exception.DataImportException;
import org.example.exception.InvalidDataException;
import org.example.exception.NoSuchOptionException;
import org.example.io.ConsolePrinter;
import org.example.io.DataReader;
import org.example.io.file.FileManager;
import org.example.io.file.FileManagerBuilder;
import org.example.model.*;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Optional;

public class RentalControl {

   private ConsolePrinter printer = new ConsolePrinter();
   private DataReader dataReader = new DataReader(printer);
   private Rental rental;
   private FileManager fileManager;

    RentalControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            rental = fileManager.importData();
            printer.printLine("Zaimportowano dane z pliku");
        } catch (DataImportException | InvalidDataException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjonowano nową bazę");
            rental = new Rental();
        }
    }

    public void controlLoop(){
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option){
                case EXIT -> exit();
                case ADD_CAR -> addCar();
                case ADD_TRUCK -> addTruck();
                case ADD_MOTORCYCLE -> addMotorcycle();
                case DISPLAY_CARS -> printCars();
                case DISPLAY_TRUCKS -> printTrucks();
                case DISPLAY_MOTORCYCLES -> printMotorcycle();
                case DELETE_CAR -> deleteCar();
                case DELETE_TRUCK -> deleteTruck();
                case DELETE_MOTORCYCLE -> deleteMotorcylce();
                case ADD_CLIENT -> addRentalUser();
                case DISPLAY_CLIENTS -> printUsers();
                case FIND_VEHICLE -> findVehicle();
                default -> System.out.println("Brak wybranej opcji, spróbuj raz jeszcze");
            }
        } while (option != Option.EXIT);
    }

    private void findVehicle() {
        printer.printLine("Podaj numer rejsetracyjny do wyczukiania:");
        String registrationNumber = dataReader.getString();
        rental.findByRegisterNumber(registrationNumber)
                .map(Vehicle::toString)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Brak pojazdu o podanym numerze rejestracyjnym")
                );
    }

    private void deleteMotorcylce() {
        try {
            Motorcycle motorcycle = dataReader.createMotorcycle();
            if (rental.deleteVehicle(motorcycle))
                System.out.println("Usunięto motoru z bazy");
            else
                System.out.println("Brak danego motoru w bazie");
        } catch (InputMismatchException e){
            System.out.println("Nie udało się utworzyć motocyklu, błędne dane");
        }
    }

    private void deleteTruck() {
        try {
            Truck truck = dataReader.createTruck();
            if (rental.deleteVehicle(truck))
                System.out.println("Usunięto vana z bazy");
            else
                System.out.println("Brak danego vana w bazie");
        } catch (InputMismatchException e) {
            System.out.println("Nie udało się utworzyć vana, błędne dane");
        }
    }

    private void exit() {
        try {
            fileManager.exportData(rental);
            printer.printLine("Eksport danych zakończony powodzeniem");
        } catch (DataExportException e){
            printer.printLine(e.getMessage());
        }
        printer.printLine("Koniec programu!!!");
        dataReader.closeScanner();
    }

    private void printMotorcycle(){
        printer.printMotorcycle(rental.sortVehicle());
    }

    private void printCars(){
        printer.printCars(rental.sortVehicle());
    }

    private void printTrucks(){
        printer.printTrucks(rental.sortVehicle());
    }

    private void printUsers(){
        Collection<User> userCollection = rental.getUsers().values();
        printer.printUsers(userCollection);
    }

    private void deleteCar() {
        try {
            Car car = dataReader.createCar();
            if (rental.deleteVehicle(car)) {
                System.out.println("Usunięto samochód z bazy");
            } else {
                System.out.println("Brak danego auta w bazie");
            }
        } catch (InputMismatchException e) {
            System.out.println("Nie udało się utworzyć motcykla, błędne dane");
        }
    }

    private void addRentalUser() {
        try {
            RentalUser user = dataReader.createUser();
            rental.addUser(user);
        } catch (InputMismatchException e){
           printer.printLine("Nie udało się utworzyć klienta");
        }
    }

    private void addMotorcycle() {
        try {
            Motorcycle motorcycle = dataReader.createMotorcycle();
            rental.addVehicle(motorcycle);
        } catch (InputMismatchException e){
            System.out.println("Nie udało się utworzyć motcykla, błędne dane");
        }
    }

    private void addTruck() {
        try {
            Truck truck = dataReader.createTruck();
            rental.addVehicle(truck);
        } catch (InputMismatchException e) {
            System.out.println("Nie udało się utworzyć samochodu, błędne dane");
        }
    }

    private void addCar() {
        try {
            Car car = dataReader.createCar();
            rental.addVehicle(car);
        } catch (InputMismatchException e) {
            System.out.println("Nie udało się utworzyć samochodu, błędne dane");
        }
    }

    private Option getOption() {
        Option option = null;
        boolean isNumCorrect = false;
        while (!isNumCorrect){
            try {
                option = Option.getOptionFromInt(dataReader.getInt());
                isNumCorrect =true;
            } catch (NoSuchOptionException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Wpisano wartość, która nie jest liczbą z podanego zakresu, wybierz ponownie: ");
            }
        }
        return option;
    }

    private void printOptions() {
        System.out.println("Proszę wybrać opcję: ");
        Option[] values = Option.values();
        for (Option option : values) {
            System.out.println(option.toString());
        }
    }

    private enum Option{
        EXIT(0, "Wyjście z aplikacji"),
        ADD_CAR(1, "Dodanie samochodu"),
        ADD_TRUCK(2, "Dodanie vana"),
        ADD_MOTORCYCLE(3, "Dodanie motocykla"),
        DISPLAY_CARS(4, "Wyświetlenie samochodów osobowych"),
        DISPLAY_TRUCKS(5, "Wyświetlenie vanów"),
        DISPLAY_MOTORCYCLES(6, "Wyświetlenie motocykli"),
        DELETE_CAR(7, "Usunięcie samochodu osobowego"),
        DELETE_TRUCK(8, "Usunięcie vana"),
        DELETE_MOTORCYCLE(9, "Usunięcie motocykla"),
        ADD_CLIENT(10, "Dodanie klienta wypożyczalni"),
        DISPLAY_CLIENTS(11, "Wyświetlenie klientów"),
        FIND_VEHICLE(12, "Wyszukanie pojazdu");


        private final int number;

        private final String description;

        Option(int number, String description) {
            this.number = number;
            this.description = description;
        }

        public int getNumber() {
            return number;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return number +
                    ". " + description;
        }

        private static Option getOptionFromInt(int optionNumber) throws NoSuchOptionException {
            try {
                return Option.values()[optionNumber];
            } catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o numerze: " + optionNumber + " , wybierz ponownie.");
            }
        }
    }
}
