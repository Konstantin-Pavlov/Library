package org.library;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("success - jdbc driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("jdbc driver failed to load");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
            System.out.println("database loaded");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, author_id, year, name from library.book");


            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String author_id = resultSet.getString("author_id");
                String year = resultSet.getString("year");
                String name = resultSet.getString("name");


                System.out.printf("%-2s %-2s %-4s %-25s%n", id, author_id, year, name);

            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("database failed to load");
            e.printStackTrace();
        }

//        Library library = new Library("City Public Library", "17th street", "Thompson", 1876, true);
//        Author Bill = new Author("Bill", "Harrison", LocalDate.of(1895, 2, 25));
//        Author John = new Author("John", "Darvin", LocalDate.of(1954, 7, 3));
//        Author Martin = new Author("Martin", "Reed", LocalDate.of(1789, 4, 16));
//
//        Book theBeast = new Book("The beast", Martin, 51, 1841);
//
//        library.addBook(new Book("Great Book", Bill, 79, 1929));
//        library.addBook(new Book("Outstanding cat", John, 42, 1984));
//        library.addBook(theBeast);
//        library.addBook(new Book("Great Book", Bill, 79, 1929));
//
//        library.addReader(new Client("Nick", "Romanoff", LocalDate.of(2009, 4, 3)));
//        library.addReader(new Client("Jack", "Soul", LocalDate.of(1999, 8, 1)));
//        library.addEmployee(new Employee("David", "Norfolk", LocalDate.of(1978, 7, 24), 1));
//        library.addEmployee(new Employee("Ray", "Norton", LocalDate.of(1987, 9, 24), 2));
//
//        Book book1 = new Book("Great Book", Bill, 79, 1929);
//        Book book2 = new Book("Great Book", Bill, 79, 1929);
//        Author writer = new Author("Martin", "Reed", LocalDate.of(1789, 4, 16));
//        writer.addBook(theBeast);
//
//        System.out.println(book1);
//        System.out.println(book1.equals(book2));
//        System.out.println(Martin.equals(writer));
//        System.out.println(Martin.equals(John));
//
//        System.out.println();
//
//        System.out.println(library.getAuthorsList());
//        System.out.println(library.getBooksList());
//        System.out.println(library.getTotalNumberOfPeople());
//
//        System.out.println();
//
//        for (Book book : library.getBooksList()) {
//            System.out.println("Title: " + book.getTitle() + " " + "Author: " + book.getAuthor().getFullName());
//        }
//
//        System.out.println();
//
//        for (Author author : library.getAuthorsList()) {
//            System.out.println("Name: " + author.getFullName() + " " + "Author's books: " + author.getAuthorsBooksList());
//        }
//
//
//        for (Client client : library.getReaders()) {
//            System.out.println("name: " + client.getFullName() + ". Is minor? " + (client.isMinor() ? "yes." : "no.") + " Age: " + client.getAge());
//        }
//
//        System.out.println();
//
//        for (Employee employee : library.getEmployees()) {
//            System.out.println("name: " + employee.getFullName() + " Age: " + employee.getAge());
//        }
//
//        System.out.println();
//
//        System.out.println(library);


    }
}
