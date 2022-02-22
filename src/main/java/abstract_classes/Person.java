package abstract_classes;

import java.time.LocalDate;

//People implements Person is wrong
//  убрать всё в Person?
//  убрать пакеты

public abstract class Person {
      String firstName;
      String lastName;
      LocalDate dateOfBirth;



    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public abstract String getData();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
