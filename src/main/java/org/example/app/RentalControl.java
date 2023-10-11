package org.example.app;

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
            }
        } while (option != Option.EXIT);

    }

    private Option getOption() {
        Option option = null;
        int optionNumber = scanner.nextInt();
        for (Option value : Option.values()) {
            if (value.getNumber() == optionNumber) {
                option = value;
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
        EXIT(1, "Wyjście z aplikacji"),
        ADD_CAR(2, "Dodanie samochodu"),
        ADD_TRUCK(3, "Dodanie vana"),
        ADD_MOTORCYCLE(4, "Dodanie motocykla"),
        DISPLAY_CARS(5, "Wyświetlenie samochodów osobowych"),
        DISPLAY_TRUCKS(6, "Wyświetlenie vanów"),
        DISPLAY_MOTORCYCLES(7, "Wyświetlenie motocykli"),
        DELETE_CAR(8, "Usunięcie samochodu osobowego"),
        DELETE_TRUCK(9, "Usunięcie vana"),
        DELETE_MOTORCYCLE(10, "Usunięcie motocykla"),
        ADD_CLIENT(11, "Dodanie klienta wypożyczalni"),
        DISPLAY_CLIENTS(12, "Wyświetlenie klientów"),
        FIND_VEHICLE(13, "Wyszukanie pojazdu");

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
    }



}
