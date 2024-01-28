package org.library.model;

import org.library.abstract_classes.Person;

import java.time.LocalDate;
import java.time.Period;

public class Visitor extends Person {

    public Visitor(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    public boolean isMinor() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears() < 18;
    }

    public int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor AnotherClient = (Visitor) o;
        return this.getFirstName().equals(AnotherClient.getFirstName()) &&
                this.getLastName().equals(AnotherClient.getLastName()) &&
                this.getDateOfBirth().equals(AnotherClient.getDateOfBirth());
    }

    @Override
    public String getData() {
        return toString();
    }

    @Override
    public String toString() {
        return "Client{" + "firstName='" +
                getFirstName() + '\'' +
                ", lastName='" + getLastName() +
                '\'' + ", dateOfBirth=" +
                getDateOfBirth() + '}';
    }
}

