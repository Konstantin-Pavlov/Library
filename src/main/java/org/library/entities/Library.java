package org.library.entities;

import org.library.model.Author;
import org.library.model.Book;
import org.library.model.Client;
import org.library.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Library extends Building {
    public static int booksCount = 0;
    public static int readersCount = 0;
    public static int employeesCount = 0;
    public static int authorsCount = 0;

    private final List<Book> books = new ArrayList<>();
    private final List<Author> authors = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Client> readers = new ArrayList<>();

    public Library(String name, String address, String architect, int year, boolean isCulturalMonument) {
        super(name, address, architect, year, isCulturalMonument);
    }

    public List<Book> getBooksList() {
        return books;
    }

    public List<Author> getAuthorsList() {
        return authors;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Client> getReaders() {
        return readers;
    }

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        book.getAuthor().addBook(book);
        booksCount++;
        authorsCount++;
    }

    public void addReader(Client client) {
        readers.add(client);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int getTotalNumberOfPeople() {
        return readers.size() + employees.size();
    }


    @Override
    public String toString() {
        return super.toString() + ", " +
                "books=" + booksCount +
                ", authors=" + authorsCount +
                ", readers=" + readers.size() +
                ", employees=" + employees.size();
    }
}
