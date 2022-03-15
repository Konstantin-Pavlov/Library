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

    int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client AnotherClient = (Client) o;
        return this.firstName.equals(AnotherClient.firstName) && this.lastName.equals(AnotherClient.lastName) && this.dateOfBirth.equals(AnotherClient.dateOfBirth);
    }

    @Override
    public String getData() {
        return toString();
    }

    @Override
    public String toString() {
        return "Client{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", dateOfBirth=" + dateOfBirth + '}';
    }
}

