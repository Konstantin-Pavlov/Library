package org.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    boolean isTheSameAuthor(Author that) {
        return this.getFullName().equals(that.getFullName()) && this.getDateOfBirth().equals(that.getDateOfBirth());

    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getAuthorsBooksList(){
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
