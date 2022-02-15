package classes;

import interfaces.Person;

import java.time.LocalDate;
import java.util.List;

public class Author implements Person {
    private final String name;
    private final LocalDate dateOfBirth;
    private List<Book> books;

    public Author(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // is this the same author as the given one?
    boolean isTheSameAuthor(Author that) {
        return this.name.equals(that.name) &&
                this.dateOfBirth.equals(that.dateOfBirth);
    }

    @Override
    public String getData() {
        return toString();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
