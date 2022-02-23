package org.library;

import java.time.LocalDate;

public class Employee extends Person{
    private final int id;
    public Employee(String firstName, String lastName, LocalDate dateOfBirth, int id) {
        super(firstName, lastName, dateOfBirth);
        this.id = id;
    }

    @Override
    public String getData() {
        return null;
    }

    public int getId() {
        return id;
    }
}
