import abstract_classes.Building;
import classes.Author;
import classes.Book;

import java.util.List;

public class Library extends Building {
    public static int booksCount = 0;
    public static int readersCount = 0;
    public static int employeesCount = 0;

    private List<Book> books;
    private List<Author> authors;

    public Library(String name, String address, String architect, int year, boolean isCulturalMonument) {
        super(name, address, architect, year, isCulturalMonument);
    }
    
    public List<Book> getBooksList() {
        return books;
    }

    public List<Author> getAuthorsList() {
        return authors;
    }

    public void addBook() {
        booksCount++;
    }

    public void addReader() {
        readersCount++;
    }

    public int getTotalNumberOfPeople() {
        return readersCount + employeesCount;
    }

}
