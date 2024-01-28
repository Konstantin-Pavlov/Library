package org.library;

import org.library.entities.Library;
import org.library.model.Author;
import org.library.model.Book;
import org.library.model.Employee;
import org.library.model.Visitor;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        loadJdbcDriver();

        Library library = new Library("City Public Library", "17th street", "Thompson", 1876, true);


    }

    private static void printBooksFromDatabase() {
        try (Connection connection = connectToDatabase()) {
            System.out.println("database loaded");

            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select id, author_id, year, name from library.book");
            ResultSet resultSet = statement.executeQuery("select * from library.book order by year");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String authorId = resultSet.getString("author_id");
                String year = resultSet.getString("year");
                String name = resultSet.getString("name");

                System.out.printf("%-2s %-2s %-4s %-10s%n", id, authorId, year, name);

            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("database failed to load");
            e.printStackTrace();
        }

    }

    private static void loadJdbcDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Success - JDBC driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver failed to load");
            e.printStackTrace();
        }
    }

    private static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
    }

    private static void addAuthorToDatabase(Author author) {

        try (Connection connection = connectToDatabase()) {
            System.out.println("Database loaded");

            // Sample data for a new author
            String name = author.getFirstName();
            String surname = author.getLastName();
            int numberOfBooks = author.getAuthorsBooksList().size();
            LocalDateTime birthDate = author.getDateOfBirth().atStartOfDay();

            // Format birthDate as a String in "yyyy-MM-dd" format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedBirthDate = birthDate.format(formatter);

            // Check if the author already exists
            if (!authorExists(connection, name, surname, birthDate)) {
                // Insert data into the author table
                String insertQuery = "INSERT INTO library.author (name, surname, number_of_books, birth_date) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, surname);
                    preparedStatement.setInt(3, numberOfBooks);
                    preparedStatement.setDate(4, Date.valueOf(formattedBirthDate));

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Author added successfully!");
                    } else {
                        System.out.println("Failed to add author.");
                    }
                } catch (SQLException ex) {
                    if (ex.getSQLState().startsWith("23")) { // Check for SQL state indicating integrity violation
                        System.out.println("Failed to add author. Duplicate record.");
                    } else {
                        throw ex; // Rethrow if it's a different type of SQL exception
                    }
                }
            } else {
                System.out.println("Author already exists. Skipping insertion.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addBookToDatabase(Book book) {
        // Sample data for a new author
        int authorId = getAuthorId(book.getAuthor());
        int yearOfCreation = book.getYearOfCreation();
        String title = book.getTitle();

        if (authorId == -1) {
            System.out.println("failed to find author");
            return;
        }

        System.out.println("success - found author: " + book.getAuthor().getFullName());

        try (Connection connection = connectToDatabase()) {
            System.out.println("Database loaded");

            // Check if the author already exists
            if (!bookExists(connection, authorId, title, yearOfCreation)) {
                // Insert data into the author table
                String insertQuery = "INSERT INTO library.book (author_id, year, name) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setInt(1, authorId);
                    preparedStatement.setInt(2, yearOfCreation);
                    preparedStatement.setString(3, title);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Failed to add book.");
                    }
                } catch (SQLException ex) {
                    if (ex.getSQLState().startsWith("23")) { // Check for SQL state indicating integrity violation
                        System.out.println("Failed to add book. Duplicate record.");
                    } else {
                        throw ex; // Rethrow if it's a different type of SQL exception
                    }
                }
            } else {
                System.out.println("Book already exists. Skipping insertion.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }
    private static void addVisitorToDatabase(Visitor visitor) {

        try (Connection connection = connectToDatabase()) {
            System.out.println("Database loaded");

            // Sample data for a new author
            String name = visitor.getFirstName();
            String surname = visitor.getLastName();
            LocalDateTime birthDate = visitor.getDateOfBirth().atStartOfDay();

            // Format birthDate as a String in "yyyy-MM-dd" format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedBirthDate = birthDate.format(formatter);

            // Check if the author already exists
            if (!visitorExists(connection, name, surname, birthDate)) {
                // Insert data into the author table
                String insertQuery = "INSERT INTO library.visitor (name, surname, birth_date) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, surname);
                    preparedStatement.setDate(3, Date.valueOf(formattedBirthDate));

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Visitor added successfully!");
                    } else {
                        System.out.println("Failed to add visitor.");
                    }
                } catch (SQLException ex) {
                    if (ex.getSQLState().startsWith("23")) { // Check for SQL state indicating integrity violation
                        System.out.println("Failed to add visitor. Duplicate record.");
                    } else {
                        throw ex; // Rethrow if it's a different type of SQL exception
                    }
                }
            } else {
                System.out.println("Visitor already exists. Skipping insertion.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    private static void addEmployeeToDatabase(Employee employee) {

        try (Connection connection = connectToDatabase()) {
            System.out.println("Database loaded");

            // Sample data for a new author
            String name = employee.getFirstName();
            String surname = employee.getLastName();
            LocalDateTime birthDate = employee.getDateOfBirth().atStartOfDay();

            // Format birthDate as a String in "yyyy-MM-dd" format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedBirthDate = birthDate.format(formatter);

            // Check if the author already exists
            if (!employerExists(connection, name, surname, birthDate)) {
                // Insert data into the author table
                String insertQuery = "INSERT INTO library.employee (name, surname, birth_date) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, surname);
                    preparedStatement.setDate(3, Date.valueOf(formattedBirthDate));

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Employee added successfully!");
                    } else {
                        System.out.println("Failed to add employee.");
                    }
                } catch (SQLException ex) {
                    if (ex.getSQLState().startsWith("23")) { // Check for SQL state indicating integrity violation
                        System.out.println("Failed to add employee. Duplicate record.");
                    } else {
                        throw ex; // Rethrow if it's a different type of SQL exception
                    }
                }
            } else {
                System.out.println("Employee already exists. Skipping insertion.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void printAuthorsFromDatabase() {
        try (Connection connection = connectToDatabase()) {
            System.out.println("database loaded");

            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select id, author_id, year, name from library.book");
            ResultSet resultSet = statement.executeQuery("select id, name, surname, number_of_books, birth_date from library.author");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String number_of_books = resultSet.getString("number_of_books");
                String birth_date = resultSet.getString("birth_date");

                System.out.printf("%-2s %-10s %-10s %-2s %-10s%n", id, name, surname, number_of_books, birth_date);

            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("database failed to load");
        }
    }

    private static boolean authorExists(Connection connection, String name, String surname, LocalDateTime birthDate) throws SQLException {
        String query = "SELECT COUNT(*) FROM library.author WHERE name = ? AND surname = ? AND birth_date = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setDate(3, Date.valueOf(birthDate.toLocalDate()));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    private static boolean visitorExists(Connection connection, String name, String surname, LocalDateTime birthDate) throws SQLException {
        String query = "SELECT COUNT(*) FROM library.visitor WHERE name = ? AND surname = ? AND birth_date = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setDate(3, Date.valueOf(birthDate.toLocalDate()));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    private static boolean employerExists(Connection connection, String name, String surname, LocalDateTime birthDate) throws SQLException {
        String query = "SELECT COUNT(*) FROM library.employee WHERE name = ? AND surname = ? AND birth_date = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setDate(3, Date.valueOf(birthDate.toLocalDate()));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private static boolean bookExists(Connection connection, int author_id,  String title, int yearOfCreation ) throws SQLException {
        String query = "SELECT COUNT(*) FROM library.book WHERE author_id = ? AND year= ? AND name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, author_id);
            preparedStatement.setInt(2, yearOfCreation);
            preparedStatement.setString(3, title);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private static int getAuthorId(Author author) {
        try (Connection connection = connectToDatabase()) {
            System.out.println("database loaded");

            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select id, author_id, year, name from library.book");
            ResultSet resultSet = statement.executeQuery("select id, name, surname, number_of_books, birth_date from library.author");

            // Define the format of the date string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String number_of_books = resultSet.getString("number_of_books");
                String birth_date = resultSet.getString("birth_date");

                Author currentAuthor = new Author(name, surname, LocalDate.parse(birth_date, formatter));

                if (author.equals(currentAuthor)) {
                    return Integer.parseInt(id);
                }

            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("database failed to load");
//            e.printStackTrace();
        }
        return -1;
    }
}
