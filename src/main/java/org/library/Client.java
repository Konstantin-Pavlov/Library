package org.library;

import java.time.LocalDate;
import java.time.Period;

public class Client extends Person {
    boolean minor;

    public Client(String firstName, String lastName, LocalDate dateOfBirth, boolean minor) {
        super(firstName, lastName, dateOfBirth);
        this.minor = minor;
    }

    boolean isMinor() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears() < 18;
    }

    @Override
    public String getData() {
        return null;
    }
}

