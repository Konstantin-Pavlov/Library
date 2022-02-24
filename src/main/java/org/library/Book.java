package org.library;

public class Book {
    private String title;
    private Author author;
    private int price;
    private int yearOfCreation;

    public Book(String title, Author author, int price, int yearOfCreation) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearOfCreation = yearOfCreation;
    }

    public Book getBook() {
        return this;
    }

    public boolean isTheSameBook(Book that){
        return this.title.equals(that.title) && this.author.equals(that.author) && this.yearOfCreation == that.yearOfCreation;
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
