package org.library;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("City Public Library", "17th street", "Thompson", 1876, true);
        Author Bill = new Author("Bill", "Harrison", LocalDate.of(1895, 2, 25));
        Author John = new Author("John", "Darvin", LocalDate.of(1954, 7, 3));
        Author Martin = new Author("Martin", "Reed", LocalDate.of(1789, 4, 16));

        library.addBook(new Book("Great Book", Bill, 79, 1929));
        library.addBook(new Book("Outstanding cat", John, 42, 1984));
        library.addBook(new Book("The beast", Martin, 51, 1841));

        System.out.println(library.getAuthorsList());
        System.out.println(library.getBooksList());
        System.out.println(library.getTotalNumberOfPeople());
        System.out.println(library);


    }
}
