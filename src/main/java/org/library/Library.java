package org.library;

import java.util.ArrayList;
import java.util.List;

public class Library extends Building {
    public static int booksCount = 0;
    public static int readersCount = 0;
    public static int employeesCount = 0;
    public static int authorsCount = 0;

    private final List<Book> books = new ArrayList<>();
    private final List<Author> authors = new ArrayList<>();

    public Library(String name, String address, String architect, int year, boolean isCulturalMonument) {
        super(name, address, architect, year, isCulturalMonument);
    }
    
    public List<Book> getBooksList() {
        return books;
    }

    public List<Author> getAuthorsList() {
        return authors;
    }

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.author);
        booksCount++;
        authorsCount++;
    }

    public void addReader() {
        readersCount++;
    }

    public int getTotalNumberOfPeople() {
        return readersCount + employeesCount;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "books=" + booksCount +
                ", authors=" + authorsCount;
    }
}
