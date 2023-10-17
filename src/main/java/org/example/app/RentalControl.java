package org.example.app;

import org.example.exception.NoSuchOptionException;
import org.example.io.ConsolePrinter;
import org.example.io.DataReader;
import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Rental;
import org.example.model.Truck;

import java.util.InputMismatchException;

public class RentalControl {
   Rental rental = new Rental();
   DataReader dataReader = new DataReader();

   ConsolePrinter printer = new ConsolePrinter();

    public void controlLoop(){
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option){
                case EXIT -> System.out.println("Koniec");
                case ADD_CAR -> addCar();
                case ADD_TRUCK -> addTruck();
                case ADD_MOTORCYCLE -> addMotorcycle();
                case DISPLAY_CARS -> System.out.println("wyswietl auta");
                case DISPLAY_TRUCKS -> System.out.println("wyświetl vany");
                case DISPLAY_MOTORCYCLES -> System.out.println("Wyświetl motory");
                case DELETE_CAR -> deleteCar();
                case DELETE_TRUCK -> System.out.println("usuń vana");
                case DELETE_MOTORCYCLE -> System.out.println("usuń motor");
                case ADD_CLIENT -> System.out.println("dodaj klienta");
                case DISPLAY_CLIENTS -> System.out.println("wyświel klientów");
                case FIND_VEHICLE -> System.out.println("znajd auto");
                default -> System.out.println("Brak wybranej opcji, spróbuj raz jeszcze");
            }
        } while (option != Option.EXIT);
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
