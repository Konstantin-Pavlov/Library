package org.library;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee extends Person {
    private final int id;

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, int id) {
        super(firstName, lastName, dateOfBirth);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee AnotherEmployee = (Employee) o;
        return this.id == AnotherEmployee.id &&
                this.firstName.equals(AnotherEmployee.firstName) &&
                this.lastName.equals(AnotherEmployee.lastName) &&
                this.dateOfBirth.equals(AnotherEmployee.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
