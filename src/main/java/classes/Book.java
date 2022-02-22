package classes;

public class Book {
    String title;
    Author author;
    int price;
    int yearOfCreation;

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
}
