package org.example.model;

import java.io.Serializable;

public abstract class User implements Serializable, CsvConvertible {
    private String firstName;
    private String secondName;
    private String pesel;

    public User(String firstName, String secondName, String pesel) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return  "; " + firstName +
                "; " + secondName + '\'' +
                "; " + pesel;
    }


}

