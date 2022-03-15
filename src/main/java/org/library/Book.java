package org.library;

import java.util.Objects;

public class Book {
    private final String title;
    private final Author author;
    private final int price;
    private final int yearOfCreation;

    public Book(String title, Author author, int price, int yearOfCreation) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearOfCreation = yearOfCreation;
    }


    // is the same book
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book AnotherBook = (Book) o;
        return this.price == AnotherBook.price &&
                this.yearOfCreation == AnotherBook.yearOfCreation &&
                this.title.equals(AnotherBook.title) &&
                this.author.equals(AnotherBook.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, yearOfCreation);
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author.getFullName() +
                ", price=" + price +
                ", yearOfCreation=" + yearOfCreation +
                '}';
    }
}
