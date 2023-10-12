package org.example.app;

import org.example.exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalControl {

    Scanner scanner = new Scanner(System.in);

    public void controlLoop(){
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option){
                case EXIT -> System.out.println("Koniec");
                case ADD_CAR -> System.out.println("Dodaj auto");
                case ADD_TRUCK -> System.out.println("Dodaj vana");
                case ADD_MOTORCYCLE -> System.out.println("Dodaj mmotocykl");
                case DISPLAY_CARS -> System.out.println("wyświetl samochody");
                case DISPLAY_TRUCKS -> System.out.println("wyświetl vany");
                case DISPLAY_MOTORCYCLES -> System.out.println("Wyświetl motory");
                case DELETE_CAR -> System.out.println("usun auto");
                case DELETE_TRUCK -> System.out.println("usuń vana");
                case DELETE_MOTORCYCLE -> System.out.println("usuń motor");
                case ADD_CLIENT -> System.out.println("dodaj klienta");
                case DISPLAY_CLIENTS -> System.out.println("wyświel klientów");
                case FIND_VEHICLE -> System.out.println("znajd auto");
                default -> System.out.println("Brak wybranej opcji, spróbuj raz jeszcze");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        Option option = null;
        boolean isNumCorrect = false;
        while (!isNumCorrect){
            try {
                int optionNumber = scanner.nextInt();
                option = Option.getOptionFromInt(optionNumber);
                isNumCorrect =true;
            } catch (NoSuchOptionException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e){
                System.err.println("Wpisano wartość, która nie jest liczbą z podanego zakresu, wybierz ponownie: ");
            } finally {
                scanner.nextLine();
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
            Option option;
            try {
                option = Option.values()[optionNumber];
            } catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o numerze: " + optionNumber + " , wybierz ponownie.");
            }
            return option;
        }
    }



}
