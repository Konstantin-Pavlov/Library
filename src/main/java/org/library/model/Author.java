package org.library.model;


import org.library.abstract_classes.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Person {
    private final List<Book> books = new ArrayList<>();
    public static int numberOfAuthors = 0;

    {
        onCreate();
    }

    public Author(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);

    }

    // is this the same author as the given one?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author AnotherAuthor = (Author) o;
        return
                this.getFirstName().equals(AnotherAuthor.getFirstName()) &&
                this.getLastName().equals(AnotherAuthor.getLastName()) &&
                this.getDateOfBirth().equals(AnotherAuthor.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("book already added to this author");
            return;
        }
        books.add(book);
    }

    public List<Book> getAuthorsBooksList() {
        return books;
    }

    @Override
    public String getData() {
        return toString();
    }

    private void onCreate() {
        numberOfAuthors++;
    }

    public String toString() {
        return "Author name: " + getFullName() + ", dateOfBirth: " + getDateOfBirth() + "\n";
    }
}
