package org.library;

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
        return Objects.equals(books, AnotherAuthor.books) &&
                this.firstName.equals(AnotherAuthor.firstName) &&
                this.lastName.equals(AnotherAuthor.lastName) &&
                this.dateOfBirth.equals(AnotherAuthor.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAuthorsBooksList() {
        return books;
    }

    private void onCreate() {
        numberOfAuthors++;
    }

    @Override
    public String getData() {
        return toString();
    }

    public String toString() {
        return "org.library.Author{" + "name='" + getFullName() + '\'' + ", dateOfBirth=" + getDateOfBirth() + '}';
    }
}
