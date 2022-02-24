package org.library;

import java.time.LocalDate;
import java.time.Period;

public class Client extends Person {

    public Client(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    boolean isMinor() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears() < 18;
    }

    int getAge(){
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public String getData() {
        return toString();
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

