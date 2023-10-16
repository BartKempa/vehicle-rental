package org.example.model;

public class RentalUser extends User{


    public RentalUser(String firstName, String secondName, String pesel) {
        super(firstName, secondName, pesel);
    }

    @Override
    public String toCsv() {
        return getFirstName() + ";" + getSecondName() + ";" + getPesel();
    }
}
