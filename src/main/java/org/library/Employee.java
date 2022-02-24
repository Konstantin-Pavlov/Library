package org.library;

import java.time.LocalDate;
import java.time.Period;

public class Employee extends Person{
    private final int id;
    public Employee(String firstName, String lastName, LocalDate dateOfBirth, int id) {
        super(firstName, lastName, dateOfBirth);
        this.id = id;
    }

    @Override
    public String getData() {
        return toString();
    }


    public int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
