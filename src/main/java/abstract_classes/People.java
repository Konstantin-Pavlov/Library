package abstract_classes;

import interfaces.Person;

import java.time.LocalDate;

public abstract class People implements Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private int totalNumberOfPeople = 0;

    {
        onCreate();
    }

    public People(String firstName, String lastName, LocalDate dateOfBirth, int totalNumberOfPeople) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.totalNumberOfPeople = totalNumberOfPeople;
    }

    private void onCreate() {
        totalNumberOfPeople++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTotalNumberOfPeople() {
        return totalNumberOfPeople;
    }
}
